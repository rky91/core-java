package com.cube.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cube.domain.Price;
import com.cube.service.PriceService;


@Controller
public class MainController {
	private final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private PriceService priceService;
	
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
	
	
	@RequestMapping("/priceDetails")
	public String addNewPriceDetails(Model model) {
		model.addAttribute("priceDetailsObj", new Price());
		return "priceDetails";
	}
	
	
	@GetMapping("/addOrUpdatePrice")
	public String saveOrUpdateProduct(@ModelAttribute Price priceDetailsObj, Model model) {
		log.info("New Pricedetails : {}", priceDetailsObj);
		if(priceService.addOrUpdateNewPriceDetails(priceDetailsObj)) {
			log.info("Price details have been updated.");
		} else {
			log.info("PriceDeatils updation failed.");
		}
		model.addAttribute("priceDetailsObj", new Price());
		return "priceDetails";
	}

}
