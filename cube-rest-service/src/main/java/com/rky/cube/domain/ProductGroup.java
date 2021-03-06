package com.rky.cube.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductGroup {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String note;
	
	@OneToMany
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
