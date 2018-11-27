package com.rky.cube.repository;

import org.springframework.data.repository.CrudRepository;

import com.rky.cube.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
