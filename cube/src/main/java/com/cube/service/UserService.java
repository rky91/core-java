package com.cube.service;

import com.cube.domain.security.User;

public interface UserService {

	public User findByEmail(String email);
	
}
