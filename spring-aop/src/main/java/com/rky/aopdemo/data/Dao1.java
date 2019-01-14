package com.rky.aopdemo.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
	
	public String retrieveSomething() {
		return "Dao-1";
	}

}
