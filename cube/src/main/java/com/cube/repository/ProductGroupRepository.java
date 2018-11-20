package com.cube.repository;

import org.springframework.data.repository.CrudRepository;

import com.cube.domain.product.ProductGroup;

public interface ProductGroupRepository extends CrudRepository<ProductGroup, Long>{
	
	void deleteById(Long id);
}
