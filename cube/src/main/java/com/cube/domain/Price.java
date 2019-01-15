package com.cube.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String metalType;
	private Double price;
	
	public Price() {}
	
	

	public Price(String metalType, Double price) {
		super();
		this.metalType = metalType; 
		this.price = price;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMetalType() {
		return metalType;
	}



	public void setMetalType(String metalType) {
		this.metalType = metalType;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Price [id=" + id + ", metalType=" + metalType + ", price=" + price + "]";
	}
	
}
