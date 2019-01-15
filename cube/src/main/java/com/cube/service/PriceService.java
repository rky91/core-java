package com.cube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cube.domain.Price;
import com.cube.repository.PriceRepository;

@Service
public class PriceService {
	
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
	

}
