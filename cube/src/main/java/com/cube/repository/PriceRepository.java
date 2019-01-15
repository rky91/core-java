package com.cube.repository;

import org.springframework.data.repository.CrudRepository;

import com.cube.domain.Price;

public interface PriceRepository extends CrudRepository<Price, Long> {

}
