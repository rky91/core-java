package com.corejava.lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandleLambda {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int key = 0;
		
		process(arr, key, wrapperLambda((v,k) -> System.out.println(v/k)));
		
		
	}

	private static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer) {
		
		for(int i : arr) {
			consumer.accept(i, key);
		}
	}
	
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		
		return (v,k) -> {
			try {
				consumer.accept(v, k);
			}catch (Exception e) {
				System.out.println("Exception cought..");
			}
		};
	}
	
	

}
