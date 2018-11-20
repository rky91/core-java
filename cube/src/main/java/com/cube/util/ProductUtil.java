package com.cube.util;

import java.util.List;

import com.cube.command.ProductCommand;

public class ProductUtil {
	
	private final int gst = 5;
	private final int labourCharge = 10;
	
	
	
	public Double calculateProductEffectivePrice(List<ProductCommand> listOfCartProducts) {
		
		double grandTotalPrice = 0.0;
		
		for(ProductCommand prodCommand : listOfCartProducts) {
			
			prodCommand.setGST(calculateGstPrice(prodCommand.getProductPrice()));
			prodCommand.setLabourCharge(calculateLabourPrice(prodCommand.getProductPrice()));
			prodCommand.setEffectiveProductPrice(calculateEffectivePrice(prodCommand.getProductPrice(),
					prodCommand.getGST(), prodCommand.getLabourCharge()));
			
			grandTotalPrice = grandTotalPrice + prodCommand.getEffectiveProductPrice();
		}
		
		return grandTotalPrice;
		
	}
	
	public Double calculateGstPrice(Double price) {
		return ((price * gst)/100);
	}
	
	public Double calculateLabourPrice(Double price) {
		return ((price * labourCharge)/100);
	}
	
	public Double calculateEffectivePrice(Double price, Double gstPrice, Double labourPrice) {
		return (price+gstPrice+labourPrice);
	}

}
