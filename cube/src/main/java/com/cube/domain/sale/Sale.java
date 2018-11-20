package com.cube.domain.sale;


import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.cube.domain.product.Product;

@Entity
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Date SaleDate;
	private Long quantity;
	private String paymentStatus;
	private String customerName;
	private String salerName;
	
	@Lob
	private String customerAddress;
	
	@ManyToMany(mappedBy = "saleList")
	private Set<Product> products;
	
	public Sale(){}
	
	
	public Sale( Date saleDate, Long quantity, String paymentStatus, String customerName,
			String salerName, String customerAddress) {
		super();
		SaleDate = saleDate;
		this.quantity = quantity;
		this.paymentStatus = paymentStatus;
		this.customerName = customerName;
		this.salerName = salerName;
		this.customerAddress = customerAddress;
	}



	@Override
	public String toString() {
		return "ProductSale [Id=" + Id + ", SaleDate=" + SaleDate + ", quantity=" + quantity + ", paymentStatus="
				+ paymentStatus + ", customerName=" + customerName + ", salerName=" + salerName + ", customerAddress="
				+ customerAddress + ", products=" + products + "]";
	}


	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Date getSaleDate() {
		return SaleDate;
	}
	public void setSaleDate(Date saleDate) {
		SaleDate = saleDate;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSalerName() {
		return salerName;
	}
	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
