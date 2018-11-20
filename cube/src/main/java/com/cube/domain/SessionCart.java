package com.cube.domain;

public class SessionCart {
	
	private Long prodId;
	private Long count;
	
	
	public SessionCart(Long prodId, Long count) {
		super();
		this.prodId = prodId;
		this.count = count;
	}
	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SessionCart [prodId=" + prodId + ", count=" + count + "]";
	}
}
