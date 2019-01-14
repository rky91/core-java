package com.rky.aopdemo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rky.aopdemo.data.Dao1;


@Service
public class Business2 {
	
	@Autowired
	private Dao1 dao2;
	
	public String calculateSomething() {
		return dao2.retrieveSomething();
		//throw new RuntimeException("******** Error during Dao-2 execution *******");
	}

}
