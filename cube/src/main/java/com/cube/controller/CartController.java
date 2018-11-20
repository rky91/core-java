package com.cube.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cube.command.ProductCommand;
import com.cube.domain.SessionCart;
import com.cube.domain.product.Product;
import com.cube.domain.sale.Customer;
import com.cube.service.ProductService;
import com.cube.util.ProductUtil;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	private final static Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private ProductService productService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/home")
	public String cart(HttpSession session, Model model) {
		
		List<Product> listOfCartProducts = new ArrayList<Product>();
		Map<Long, SessionCart> cartMap = (Map<Long, SessionCart>) session.getAttribute("sessionCart");
		
		if(cartMap!= null && !cartMap.isEmpty()) {
			listOfCartProducts = productService.getCartProductList(cartMap);
		}
		if(listOfCartProducts != null && listOfCartProducts.size()>0) {
			model.addAttribute("customer", new Customer());
			model.addAttribute("status", "true");
			model.addAttribute("products", listOfCartProducts);
			double totalPrice = listOfCartProducts.stream().mapToDouble(product -> product.getProductPrice()).sum();
			model.addAttribute("totalCartPrice", totalPrice);
		} else {
			model.addAttribute("status", "false");
		}
		return "cart";
	}
	
	
	@RequestMapping("/checkout")
	public String checkOut(@ModelAttribute Customer customer, Model model, HttpSession session) {
		log.info(customer.toString());
		Double totalPrice = 0.0;
		ProductUtil util = new ProductUtil();
		
		List<ProductCommand> listOfCartProducts = new ArrayList<ProductCommand>();
		Map<Long, SessionCart> cartMap = (Map<Long, SessionCart>) session.getAttribute("sessionCart");
		
		if(cartMap!= null && !cartMap.isEmpty()) {
			listOfCartProducts = productService.getCartProductList2(cartMap);
			totalPrice = util.calculateProductEffectivePrice(listOfCartProducts);
			listOfCartProducts.forEach(prodCommand -> System.out.println(prodCommand.getProductPrice() + ", "
					+ prodCommand.getGST() + ", "
					+ prodCommand.getEffectiveProductPrice()));
		}
		
		if(listOfCartProducts != null && listOfCartProducts.size()>0) {
			model.addAttribute("prodCommands", listOfCartProducts);
			model.addAttribute("grandTotal", totalPrice);
			model.addAttribute("customer", customer);
			
		}
		
		return "checkOut";
	}

}
