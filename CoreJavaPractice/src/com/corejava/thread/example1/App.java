package com.corejava.thread.example1;

public class App {

	public static void main(String[] args) {

		Thread_A t_a = new Thread_A();
		t_a.start();
		
		Thread t_b = new Thread(new Thread_B());
		t_b.start();
		
		Thread t_c = new Thread(() -> {
			System.out.println("Hello from annonymous thread Thread_C");
			try {
				t_a.join(2000);
				System.out.println("Thread_A has been terminated so Thread_C is running again.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		});
		t_c.start();
		System.out.println("Hello from main thread.");
		
	}

}
