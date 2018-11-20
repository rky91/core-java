package com.cube.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	private final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/inventory")
	public String inventoryHome(){
		log.info("Inside InventoryHome().");
		log.debug("Inside InventoryHome().");
		log.error("Inside InventoryHome().");
		
		return "inventory";
	}
	
	@RequestMapping("/")
	public String homeMapping(){
		return "home";
	}

}
