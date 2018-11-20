package com.rky.cube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rky.cube.domain.ProductGroup;
import com.rky.cube.service.ProductGroupService;

@RestController
public class ProductGroupController {
	
	@Autowired
	private ProductGroupService productGroupService;
	
	
	@GetMapping("/product-groups")
	public List<ProductGroup> getProductGroups(){
		return productGroupService.getAllProductGroup();
	}

}
