package com.cube.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cube.service.ProductService;
import com.cube.util.CartCount;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	private ProductService prodService;

	@RequestMapping("/saleProduct")
	public String productSale() {
		System.out.println("###### Inside productSale().");
		return "sale";
	}
	
}
