package com.corejava.thread.example2;

public class ClonableExample implements Cloneable {
	
	
	private String str1;
	private String str2;
	
	
	

	public ClonableExample(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
	}

	
	
	public String getStr1() {
		return str1;
	}



	public void setStr1(String str1) {
		this.str1 = str1;
	}



	public String getStr2() {
		return str2;
	}



	public void setStr2(String str2) {
		this.str2 = str2;
	}



	public ClonableExample() {}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public String toString() {
		return "ClonableExample [str1=" + str1 + ", str2=" + str2 + "]";
	}
	
	
	

}
