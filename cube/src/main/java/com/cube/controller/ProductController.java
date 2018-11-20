package com.cube.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.cube.command.ProductCommand;
import com.cube.domain.Image;
import com.cube.domain.SessionCart;
import com.cube.domain.product.ProductGroup;
import com.cube.service.ImageService;
import com.cube.service.ProductGroupService;
import com.cube.service.ProductService;
import com.cube.util.CartCount;

@Controller
@RequestMapping("/product")
@SessionAttributes(names= {"cartCount", "sessionCart"})
public class ProductController {
	
	private final static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductGroupService prodGrpService;
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private ImageService imageService;
	
	/* Session Attributes*/
	
	@ModelAttribute("cartCount")
	public CartCount cartCount() {
		return new CartCount(0);
	}
	
	@ModelAttribute("sessionCart")
	public Map<Long, SessionCart> getSessionCart(){
		Map<Long, SessionCart> sessionCartMap = new HashMap<>();
		return sessionCartMap;
	}
	
	/* Product group */
	
	@RequestMapping("/addNewProductGroup")
	public String addProductGroup(Model model) {
		model.addAttribute("productGroup", new ProductGroup());
		model.addAttribute("panelValue", "Add new Product-group");
		return "addProductGroup";
	}
	
	@RequestMapping("/saveProductGroup")
	public String saveProductGroup(@ModelAttribute ProductGroup prodGrp, Model model) {
		System.out.println("Inside ############## > "+prodGrp.toString());
		prodGrpService.saveProductGroup(prodGrp);
		return "redirect:/product/listofProductGroup";
	}
	
	@GetMapping("/productGroup/{id}/delete")
	public String deleteProductGroup(@PathVariable String id) {
		prodGrpService.deleteProductGroupById(Long.valueOf(id));
		return "redirect:/product/listofProductGroup";
	}
	
	@GetMapping("/productGroup/{id}/update")
	public String updateProductGroup(@PathVariable String id, Model model) {
		ProductGroup prodGrp = new ProductGroup();
		prodGrp = prodGrpService.getProductGroupById(Long.valueOf(id));
		model.addAttribute("productGroup", prodGrp);
		model.addAttribute("panelValue", "Udate Product-group");
		return "addProductGroup";
	}
	
	
	@RequestMapping("/listofProductGroup")
	public String productGroupList(Model model) {
		log.info("Inisde productGroupList().");
		model.addAttribute("productGroups", prodGrpService.getListOfProductGroup());
		return "productGroupView";
	}
	
	@GetMapping("/productGroup/{id}/{prodGrpName}")
	public String ProductListByGroup(@PathVariable String id,@PathVariable String prodGrpName ,Model model) {
		model.addAttribute("products", prodService.getProductListByGroupId(Long.valueOf(id)));
		model.addAttribute("prodGroupName", prodGrpName);
		return "productView";
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//	PRODUCT
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@RequestMapping("/addNewProduct")
	public String addProduct(Model model){
		model.addAttribute("productGroupList", prodGrpService.getListOfProductGroup());
		model.addAttribute("prodCommand", new ProductCommand());
		model.addAttribute("panelValue", "Add New Product");
		return "addOrUpdateProduct";
	}
	
	@RequestMapping("/saveProduct")
	public String saveProduct(@ModelAttribute ProductCommand prodCommand){
		prodCommand.setLastUpdated(new Date());
		prodService.saveOrUpdateProduct(prodCommand);
		return "redirect:/product/listOfProducts";
	}
	
	@RequestMapping("/listOfProducts")
	public String productLists(Model model){
		model.addAttribute("products", prodService.getProductList());
		return "productView";
	}
	
	
	
	@RequestMapping("{id}/update")
	public String updateProduct(@PathVariable String id, Model model) {
		ProductCommand productCommand = new ProductCommand();
		productCommand = prodService.getProductById(Long.valueOf(id));
		model.addAttribute("productGroupList", prodGrpService.getListOfProductGroup());
		model.addAttribute("prodCommand", productCommand);
		model.addAttribute("panelValue", "Update Product");
		return "addOrUpdateProduct";
	}
	
	@GetMapping("{id}/delete")
	public String deleteProduct(@PathVariable String id) {
		prodService.deleteProductById(Long.valueOf(id));
		return "redirect:/product/listOfProducts";
	}
	
	@RequestMapping("{id}/view")
	public String viewProduct(@PathVariable String id, Model model) {
		ProductCommand productCommand = new ProductCommand();
		productCommand = prodService.getProductById(Long.valueOf(id));
		model.addAttribute("prodCommand", productCommand);
		return "productDetailsView";
	}
	
	@PostMapping("{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
		prodService.saveImageFile(Long.valueOf(id), file);
        return "redirect:/product/" + id + "/view";
    }
	
	@GetMapping("{id}/imageView")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
		log.info("inside imageView()..."+id);
		ProductCommand productCommand = new ProductCommand();
		productCommand = prodService.getProductById(Long.valueOf(id));
		
		if(productCommand.getImage() != null) {
			byte[] byteArray = new byte[productCommand.getImage().length];
            int i = 0;

            for (Byte wrappedByte : productCommand.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
		} else {
			Image image = new Image();
			image = imageService.getImageById(1L);
			
			if(image.getImage() != null) {
				byte[] byteArray = new byte[image.getImage().length];
	            int i = 0;

	            for (Byte wrappedByte : image.getImage()){
	                byteArray[i++] = wrappedByte; //auto unboxing
	            }
	            response.setContentType("image/jpeg");
	            InputStream is = new ByteArrayInputStream(byteArray);
	            IOUtils.copy(is, response.getOutputStream());
			}
			
		}
	}
}
