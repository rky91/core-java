package com.corejava.thread.synchronisation;

public class App {

	public static void main(String[] args) {

		CountDown c = new CountDown();
		
		CountDownThread t1 = new CountDownThread(c);
		CountDownThread t2 = new CountDownThread(c);

		t1.start();
		t2.start();
	}

}


class CountDown{
	
	//Here "i" is the instance variable, so it will be stored in the heap memory and heap memory is shared by each thread.
	private int i;
	
	
	synchronized void doCountDown() {
		for(i=10; i>0; i--) {//Here "int i=10" is the local variable and each thread stores it in its own thread stack
			System.out.println(Thread.currentThread().getName() + " ------ "+i);
		}
	}
	
}

class CountDownThread extends Thread{
	
	private CountDown countDown;

	public CountDownThread(CountDown countDown) {
		super();
		this.countDown = countDown;
	}

	@Override
	public void run() {
		countDown.doCountDown();
	}
	
}
