package com.cube.controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cube.domain.ErrorDomain;
import com.cube.domain.SessionCart;
import com.cube.service.ProductService;
import com.cube.util.CartCount;

@RestController
@RequestMapping("/restHome")
public class RestControllerHandler {

	@Autowired
	private ProductService prodService;
	
	List<ErrorDomain> errorList = new ArrayList<ErrorDomain>();
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateCart")
	public String updateCart(@RequestBody String prodId, HttpSession session) {
		CartCount cartCount = (CartCount) session.getAttribute("cartCount");
		Map<Long, SessionCart> sessionCartMap = (Map<java.lang.Long, SessionCart>) session.getAttribute("sessionCart");
		prodService.updateCartCount(cartCount, true);
		prodService.updateSessionCart(sessionCartMap, Long.parseLong(prodId), true);
		return ""+cartCount.getCount();
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteFromCart")
	public String deleteItemFromCart(@RequestBody String prodId, HttpSession session) {
		CartCount cartCount = (CartCount) session.getAttribute("cartCount");
		Map<Long, SessionCart> sessionCartMap = (Map<java.lang.Long, SessionCart>) session.getAttribute("sessionCart");
		prodService.updateCartCount(cartCount, false);
		prodService.updateSessionCart(sessionCartMap, Long.parseLong(prodId), false);
		return ""+cartCount.getCount();
	}
	
	
	
	
	
	
	
	
	@GetMapping("/test/{random}")
	public ResponseEntity<List<ErrorDomain>>  doTest(@PathVariable String random, @RequestParam String term,
			HttpServletResponse responce) throws IOException {
		
		System.out.println("Inside doTest() : "+term);
		
		
		if(errorList.size() < 5) {
			errorList.add(new ErrorDomain("E0001", "ok"));
			errorList.add(new ErrorDomain("E1002", "UnExpected"));
			errorList.add(new ErrorDomain("E0003", "Null pointer"));
			errorList.add(new ErrorDomain("E2004", "Number Format"));
			errorList.add(new ErrorDomain("E2005", "Number Format Exception"));
		}
		System.out.println(errorList.size());
		//return simulateSearchResult(tagName);
		return ResponseEntity.ok(searchErrorFromList(term));
		//return errorList;
	}
	
	public List<ErrorDomain> searchErrorFromList(String errorCode) {
		
		List<ErrorDomain> errList = errorList.stream()
				.filter(error -> error.getErrorId().contains(errorCode)).collect(Collectors.toList());
		System.out.println(errList.size());
		return errList;
		
	}
	
	
	
}
