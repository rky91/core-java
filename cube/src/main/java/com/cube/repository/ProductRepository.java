package com.cube.repository;

import org.springframework.data.repository.CrudRepository;

import com.cube.domain.product.Product;

import javassist.bytecode.Descriptor.Iterator;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Iterable<Product> findAllByProductGroupId(Long productGroupId);

}
