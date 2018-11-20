package com.rky.cube.domain;

import java.util.List;

public class ProductGroup {
	
	private long id;
	private String name;
	private String note;
	private List<Product> listOfProd;
	
	public ProductGroup() {}
	
	public ProductGroup(String name, String note, List<Product> listOfProd) {
		super();
		this.name = name;
		this.note = note;
		this.listOfProd = listOfProd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Product> getListOfProd() {
		return listOfProd;
	}

	public void setListOfProd(List<Product> listOfProd) {
		this.listOfProd = listOfProd;
	}

}
