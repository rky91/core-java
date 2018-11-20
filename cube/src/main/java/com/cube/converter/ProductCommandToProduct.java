package com.cube.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cube.command.ProductCommand;
import com.cube.domain.product.Product;

@Component
public class ProductCommandToProduct implements Converter<ProductCommand, Product> {

	
	@Override
	public Product convert(ProductCommand source) {
		
		if(source == null){
			System.out.println("Inside Bull ******>>>>>>>>");
			return null;
		}
		Product product = new Product();
		product.setId(source.getId());
		product.setProductName(source.getProductName());
		product.setProductType(source.getProductType());
		product.setProductPrice(source.getProductPrice());
		product.setAvailability(source.getAvailability());
		product.setAvailQty(source.getAvailQty());
		product.setLastUpdated(source.getLastUpdated());
		product.setLastUpdatedBy(source.getLastUpdatedBy());
		product.setUom(source.getUom());
		//product.setProdGrp(source.getProdGrp());
		product.setProductGroupId(source.getProductGroupId());
		product.setDescription(source.getDescription());
		product.setProductWeight(source.getProductWeight());
		product.setImage(source.getImage());
		
		return product;
	}

}
