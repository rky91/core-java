package com.corejava.lambda;

public class RunnableExample {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Inside Runnable inner-class.");
				
			}
		});
		t1.start();
		
		Thread lambdaThread = new Thread(() -> System.out.println("Inside Lambda thread."));
		lambdaThread.start();

	}

}
