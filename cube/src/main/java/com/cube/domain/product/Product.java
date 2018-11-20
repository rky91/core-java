package com.cube.domain.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.cube.domain.enumproperty.Availability;
import com.cube.domain.enumproperty.ProductType;
import com.cube.domain.enumproperty.UnitOfMeasure;
import com.cube.domain.sale.Sale;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	
	@Enumerated(value= EnumType.STRING)
	private ProductType productType;
	
	private Double productPrice;
	
	@Enumerated(value = EnumType.STRING)
	private Availability availability;
	
	@Enumerated(value= EnumType.STRING)
	private UnitOfMeasure uom;
	
	private String availQty;
	private Date lastUpdated;
	private String lastUpdatedBy;
	private Long productGroupId;
	private Long productWeight;	
	
	@Lob
	private String description;
	
	@Lob
	private Byte[] image;
	
	@ManyToMany
	@JoinTable(name = "product_sale",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "sale_id"))
	private List<Sale> saleList = new ArrayList<>();
	
	
	public Product(){}
	
	public Product(Long id, String productName, ProductType productType, Double productPrice, Availability availability,
			String availQty, Date lastUpdated, String lastUpdatedBy, UnitOfMeasure uom, Long productGroupId) {
		super();
		this.id = id;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.availability = availability;
		this.availQty = availQty;
		this.lastUpdated = lastUpdated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.uom = uom;
		this.productGroupId = productGroupId;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productType=" + productType + ", productPrice="
				+ productPrice + ", availability=" + availability + ", uom=" + uom + ", availQty=" + availQty
				+ ", lastUpdated=" + lastUpdated + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public UnitOfMeasure getUom() {
		return uom;
	}
	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public String getAvailQty() {
		return availQty;
	}
	public void setAvailQty(String availQty) {
		this.availQty = availQty;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Long getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Long productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(Long productWeight) {
		this.productWeight = productWeight;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	public List<Sale> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<Sale> saleList) {
		this.saleList = saleList;
	}

}
