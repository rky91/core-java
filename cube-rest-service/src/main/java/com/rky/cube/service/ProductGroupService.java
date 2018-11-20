package com.rky.cube.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rky.cube.domain.ProductGroup;
import com.rky.cube.repository.ProductGroupRepository;

@Service
public class ProductGroupService {
	
	private ProductGroupRepository productGroupRepository;
	
	public ProductGroupService(ProductGroupRepository productGroupRepository) {
		this.productGroupRepository = productGroupRepository;
	}
	
	
	public List<ProductGroup> getAllProductGroup(){
		List<ProductGroup> prodGrpList = new ArrayList<>();
		productGroupRepository.findAll().iterator().forEachRemaining(prodGrpList::add);
		return prodGrpList;
	}
	
	
}
