package com.rky.aopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rky.aopdemo.business.Business1;
import com.rky.aopdemo.business.Business2;

@SpringBootApplication
public class SpringAopApplication  implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private Business1 business1;
	
	@Autowired
	private Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("The BUsiness-1 output is : {}", business1.calculateSomething());
		logger.info("The BUsiness-2 output is : {}", business2.calculateSomething());
		
	}

}

