package com.cube.util;

import java.io.Serializable;

public class CartCount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6976719387535357377L;
	
	private int count;

	public CartCount(int count) {
		super();
		this.count = count;
	}

	public CartCount() {
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
