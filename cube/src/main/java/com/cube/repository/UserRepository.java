package com.cube.repository;

import org.springframework.data.repository.CrudRepository;

import com.cube.domain.security.User;


public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
