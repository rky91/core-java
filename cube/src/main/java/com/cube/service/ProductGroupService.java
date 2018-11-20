package com.cube.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cube.domain.product.ProductGroup;
import com.cube.repository.ProductGroupRepository;

@Service
public class ProductGroupService {
	
	@Autowired
	public ProductGroupRepository prodGrpRepository;
	
	public void saveProductGroup(ProductGroup prodGrp) {
		prodGrpRepository.save(prodGrp);
	}
	
	public List<ProductGroup> getListOfProductGroup(){
		List<ProductGroup> groupList = new ArrayList<>();
		prodGrpRepository.findAll().iterator().forEachRemaining(groupList::add);
		return groupList;
	}
	
	public void deleteProductGroupById(Long id) {
		prodGrpRepository.delete(id);
	}
	
	public ProductGroup getProductGroupById(Long id) {
		ProductGroup prodGrp = prodGrpRepository.findOne(id);
		
		if(prodGrp != null) {
			System.out.println(prodGrp.toString());
			return prodGrp;
		} else {
			System.out.println("Product group not found : "+id);
			return null;
		}
	}

}
