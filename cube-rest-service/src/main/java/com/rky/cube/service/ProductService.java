package com.rky.cube.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rky.cube.domain.Product;
import com.rky.cube.enumproperty.ProductType;
import com.rky.cube.enumproperty.UOM;
import com.rky.cube.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	private List<Product> prodList = new ArrayList<>();
	
	@PostConstruct
	public void bootstrap() {
		
		System.out.println("************* POST CONSTRUCT **************");
		
		prodList = Arrays.asList(new Product("Prod-1", ProductType.GOLD, UOM.Gram, 10000.00, 10, 200, new Date(), "Rakesh", 1, "NA"),
				new Product("Prod-2", ProductType.GOLD, UOM.Gram, 15000.00, 5, 500, new Date(), "Rakesh", 2, "NA"));
		
		saveProduct(prodList);
		
	}
	
	@Transactional
	public void saveProduct(List<Product> prodList) {
		productRepository.saveAll(prodList);
	}
	
	@PreDestroy
	public void preClose() {
		System.out.println("************* PRE CONSTRUCT **************");
	}
	
	
	
}
