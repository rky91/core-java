package com.cube.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cube.domain.Price;
import com.cube.repository.PriceRepository;

@Service
public class PriceService {
	
	private Logger logger = LoggerFactory.getLogger(PriceService.class.getName());
	
	@Autowired
	private PriceRepository priceRepository;
	
	//Add new metal details -> Type (GOLD/SILVER/STONE) and price
	
	public boolean addOrUpdateNewPriceDetails(Price price) {
		try {
			priceRepository.save(price);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//Get all the price details
	
	public List<Price> getPriceList(){
		List<Price> priceList = new ArrayList<Price>();
		priceRepository.findAll().iterator().forEachRemaining(priceList::add);
		logger.info("Picelist : {}", priceList);
		return priceList;
		
	}
	
	public Price getPriceDetails(Long id) {
		return priceRepository.findOne(id);
	}
	

}
