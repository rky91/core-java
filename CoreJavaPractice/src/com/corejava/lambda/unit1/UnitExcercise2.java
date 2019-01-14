package com.corejava.lambda.unit1;

import java.util.function.Function;

public class UnitExcercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getResult(10, val -> val +100));

	}
	
	
	public static Integer getResult(int val, Function<Integer, Integer> func) {
		
		
		return func.apply(val);
		
	}

}
