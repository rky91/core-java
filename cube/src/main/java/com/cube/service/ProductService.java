package com.cube.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cube.command.ProductCommand;
import com.cube.converter.ProductCommandToProduct;
import com.cube.converter.ProductToProductCommand;
import com.cube.domain.SessionCart;
import com.cube.domain.product.Product;
import com.cube.repository.ProductRepository;
import com.cube.util.CartCount;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCommandToProduct convertToProd;
	
	@Autowired
	private ProductToProductCommand converToProductCommand;
	
	public void saveOrUpdateProduct(ProductCommand productCommand){
		Product prod = new Product();
		prod = convertToProd.convert(productCommand);
		productRepository.save(prod);
	}
	
	public List<Product> getProductList(){
		List<Product> prodList = new ArrayList<Product>();
		productRepository.findAll().iterator().forEachRemaining(prodList::add);
		System.out.println("prodList size == "+prodList.size());
		return prodList;
	}
	
	public ProductCommand getProductById(Long id) {
		Product prod = new Product();
		prod = productRepository.findOne(id);
		return converToProductCommand.convert(prod);
	}
	
	public void deleteProductById(Long id) {
		productRepository.delete(id);
	}
	
	public List<Product> getProductListByGroupId(Long groupId){
		List<Product> prodList = new ArrayList<>();
		productRepository.findAllByProductGroupId(groupId).iterator().forEachRemaining(prodList::add);
		System.out.println("List size is :"+prodList.size());
		return prodList;
	}
	
	 @Transactional
	 public void saveImageFile(Long productId, MultipartFile file) {
		 try {
			 
			 System.out.println("We gor the image...");
			 Product prod = new Product();
			 prod = productRepository.findOne(productId);
			 
			 Byte[] byteObjects = new Byte[file.getBytes().length];
	         int i = 0;
	         
	         for (byte b : file.getBytes()){
	        	 byteObjects[i++] = b;
	         }
	         prod.setImage(byteObjects);
	         productRepository.save(prod);
			 
		 } catch (IOException e) {
			 e.printStackTrace();
	     }
	 }
	 
	 public CartCount updateCartCount(CartCount cc, boolean status) {
		 if(status) {
			 cc.setCount(cc.getCount() + 1);
		 } else {
			 if(cc.getCount() > 0)
			 cc.setCount(cc.getCount() - 1);
		 }
		 return cc;
	 }
	 
	 public Map<Long, SessionCart> updateSessionCart(Map<Long, SessionCart> sessionCartMap, Long prodId, boolean status){
		 if(status) {
			 if(sessionCartMap.get(prodId) != null) {
				 SessionCart sessionCart = sessionCartMap.get(prodId);
				 sessionCart.setCount(sessionCart.getCount() + 1);
				 sessionCartMap.put(prodId, sessionCart);
			 } else {
				 sessionCartMap.put(prodId, new SessionCart(prodId, 1L));
			 }
		 } else {
			 if(sessionCartMap.get(prodId) != null) {
				 sessionCartMap.remove(prodId);
			 }
		 }
		 
		 return sessionCartMap;
	 }

	 /*	 This function will get the product list for the cart
	  *  depends on the product IDs are available in the @cartMap
	  * */
	public List<Product> getCartProductList(Map<Long, SessionCart> cartMap) {
		List<Product> listOfCartProducts = new ArrayList<Product>();
		cartMap.forEach((k,v) -> listOfCartProducts.add(productRepository.findOne(k)));
		
		System.out.println("listOfCartProducts size = "+listOfCartProducts.size());
		return listOfCartProducts;
		
	}
	
	public List<ProductCommand> getCartProductList2(Map<Long, SessionCart> cartMap) {
		List<ProductCommand> listOfCartProducts = new ArrayList<ProductCommand>();
		cartMap.forEach((k,v) -> listOfCartProducts.add(converToProductCommand.convert(productRepository.findOne(k))));
		
		System.out.println("listOfCartProducts size = "+listOfCartProducts.size());
		return listOfCartProducts;
		
	}
	
}
