package com.cube.repository;

import org.springframework.data.repository.CrudRepository;

import com.cube.domain.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {
	
}
