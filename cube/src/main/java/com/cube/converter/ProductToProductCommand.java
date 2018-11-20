package com.cube.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cube.command.ProductCommand;
import com.cube.domain.product.Product;

@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand>{

	@Override
	public ProductCommand convert(Product source) {
		
		ProductCommand productCommand = new ProductCommand();
		productCommand.setId(source.getId());
		productCommand.setProductName(source.getProductName());
		productCommand.setProductType(source.getProductType());
		productCommand.setProductPrice(source.getProductPrice());
		productCommand.setAvailability(source.getAvailability());
		productCommand.setAvailQty(source.getAvailQty());
		productCommand.setLastUpdated(source.getLastUpdated());
		productCommand.setLastUpdatedBy(source.getLastUpdatedBy());
		productCommand.setUom(source.getUom());
		//productCommand.setProdGrp(source.getProdGrp());
		productCommand.setProductGroupId(source.getProductGroupId());
		productCommand.setDescription(source.getDescription());
		productCommand.setProductWeight(source.getProductWeight());
		productCommand.setImage(source.getImage());
		
		return productCommand;
		
	}

}
