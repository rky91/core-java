package com.rky.cube.domain;

import java.util.Date;

import com.rky.cube.enumproperty.ProductType;
import com.rky.cube.enumproperty.UOM;

public class Product {
	
	private long id;
	private String name;
	private ProductType type;
	private UOM uom;
	private double pricePerUnit;
	private double weightPerUnit;
	private double availableQty;
	private Date lastUpdated;
	private String updatedBy;
	private long prodGrpId;
	
	public Product() {}

	public Product(String name, ProductType type, UOM uom, double pricePerUnit, double weightPerUnit,
			double availableQty, Date lastUpdated, String updatedBy, long prodGrpId) {
		super();
		this.name = name;
		this.type = type;
		this.uom = uom;
		this.pricePerUnit = pricePerUnit;
		this.weightPerUnit = weightPerUnit;
		this.availableQty = availableQty;
		this.lastUpdated = lastUpdated;
		this.updatedBy = updatedBy;
		this.prodGrpId = prodGrpId;
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

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public UOM getUom() {
		return uom;
	}

	public void setUom(UOM uom) {
		this.uom = uom;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getWeightPerUnit() {
		return weightPerUnit;
	}

	public void setWeightPerUnit(double weightPerUnit) {
		this.weightPerUnit = weightPerUnit;
	}

	public double getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public long getProdGrpId() {
		return prodGrpId;
	}

	public void setProdGrpId(long prodGrpId) {
		this.prodGrpId = prodGrpId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", uom=" + uom + ", pricePerUnit="
				+ pricePerUnit + ", weightPerUnit=" + weightPerUnit + ", availableQty=" + availableQty
				+ ", lastUpdated=" + lastUpdated + ", updatedBy=" + updatedBy + ", prodGrpId=" + prodGrpId + "]";
	}
	
	

}
