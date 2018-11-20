package com.cube.domain.sale;


public class Customer {
	
	private String name;
	private String email;
	private Long phoneNo;
	private String address;
	
	public Customer() {}
	public Customer(String name, String email, Long phoneNo, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}
	
	

}
