package com.corejava.lambda.unit3;

public class MethodReferenceExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(MethodReferenceExample1 :: printMessage); //This is method reference syntax
																		// and its equivalent to () -> printMessage()			
		t1.start();														
	}
	
	public static void printMessage() {
		System.out.println("Hello MethodReference..");
	}

}
