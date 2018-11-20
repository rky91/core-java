package com.cube.command;

import java.util.Set;

import com.cube.domain.product.Product;

public class ProductGroupCommand {

	private Long id;
	private String number;
	private Set<Product> products;
	
	public ProductGroupCommand() {}
	
	public ProductGroupCommand(Long id, String number, Set<Product> products) {
		super();
		this.id = id;
		this.number = number;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
