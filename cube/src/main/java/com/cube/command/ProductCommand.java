package com.cube.command;

import java.util.Date;

import com.cube.domain.enumproperty.Availability;
import com.cube.domain.enumproperty.ProductType;
import com.cube.domain.enumproperty.UnitOfMeasure;
import com.cube.domain.product.ProductGroup;
import com.cube.domain.sale.Sale;

public class ProductCommand {
	
	private Long id;
	private String productName;
	private ProductType productType;
	private Double productPrice;
	private Availability availability;
	private UnitOfMeasure uom;
	private String availQty;
	private Date lastUpdated;
	private String lastUpdatedBy;
	private ProductGroup prodGrp;
	private Long productGroupId;
	private String description;
	private Long productWeight;
	private Byte[] image;
	private Double labourCharge;
	private Double GST;
	private Double effectiveProductPrice;
	
	public ProductCommand(Long id, String productName, ProductType productType, Double productPrice, Availability availability,
			String availQty, Date lastUpdated, String lastUpdatedBy, Sale prodSales, UnitOfMeasure uom, ProductGroup prodGrp) {
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
		this.prodGrp = prodGrp;
	}
	
	public ProductCommand(Long id, String productName, ProductType productType, Double productPrice, Availability availability,
			String availQty, Date lastUpdated, String lastUpdatedBy, Sale prodSales, UnitOfMeasure uom, Long productGroupId) {
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

	public ProductCommand() {
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
	public UnitOfMeasure getUom() {
		return uom;
	}

	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}


	public ProductGroup getProdGrp() {
		return prodGrp;
	}

	public void setProdGrp(ProductGroup prodGrp) {
		this.prodGrp = prodGrp;
	}

	public Long getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Long productGroupId) {
		this.productGroupId = productGroupId;
	}

	@Override
	public String toString() {
		return "ProductCommand [id=" + id + ", productName=" + productName + ", productType=" + productType
				+ ", productPrice=" + productPrice + ", availability=" + availability + ", availQty=" + availQty
				+ ", lastUpdated=" + lastUpdated + ", lastUpdatedBy=" + lastUpdatedBy + "]";
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

	public Double getEffectiveProductPrice() {
		return effectiveProductPrice;
	}

	public void setEffectiveProductPrice(Double effectiveProductPrice) {
		this.effectiveProductPrice = effectiveProductPrice;
	}

	public Double getGST() {
		return GST;
	}

	public void setGST(Double gST) {
		GST = gST;
	}

	public Double getLabourCharge() {
		return labourCharge;
	}

	public void setLabourCharge(Double labourCharge) {
		this.labourCharge = labourCharge;
	}
	
	
}
