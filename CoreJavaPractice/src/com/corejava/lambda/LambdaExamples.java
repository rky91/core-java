package com.corejava.lambda;

public class LambdaExamples {
	
	public static void main(String[] a) {
		
		MyLambdaInterface myLambda = () -> System.out.println("Hello Lambda..");
		myLambda.foo();
		
		MyLambdaAdd add = (b,c) -> b+c;
		System.out.println(add.addTwoNumbers(2, 3));
		
		MyLambdaStrLength strLength = str -> str.length();
		System.out.println("the str length is = "+ strLength.getStrLength("Rakesh"));
		
	}

}

interface MyLambdaInterface{
	void foo();
}

interface MyLambdaAdd{
	int addTwoNumbers(int a, int b);
}

interface MyLambdaStrLength{
	int getStrLength(String a);
}
