package com.corejava.thread.example1;

public class Thread_A extends Thread{

	@Override
	public void run() {
		
		System.out.println("Hello from Thread_A");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("**** Thread_A interrupted.");
			return;
		}
		
		System.out.println("5 second passed for Thread_A.");
	}

}
