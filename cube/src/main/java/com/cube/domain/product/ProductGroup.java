package com.cube.domain.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String groupNumber;
	private String groupName;
	private String comments;
	
	@OneToMany
	private Set<Product> products = new HashSet<>();

	public ProductGroup() {}

	public ProductGroup(Long id, String groupNumber, String groupName,String comments, Set<Product> products) {
		super();
		this.id = id;
		this.groupNumber = groupNumber;
		this.groupName = groupName;
		this.comments = comments;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductGroup [id=" + id + ", groupNumber=" + groupNumber + ", groupName=" + groupName + ", products="
				+ products + "]";
	}
	
	
}
