package com.corejava.thread.exectorservice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectedExecutionException {

	public static void main(String[] args) {
		
		ExecutorService service = new ThreadPoolExecutor(10, 
							30, 
							120, 
							TimeUnit.SECONDS, 
							new ArrayBlockingQueue<>(20),
							new CustomeRejectionHandler());
		
		for(int i=0;i<100;i++) {
			System.out.println("Task submitted : "+i);
			service.submit(new Task());
		}
		
	}

}

class CustomeRejectionHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
		
		System.out.println("Task got rejected due to Arrayblocking queue exeded");
		
	}
	
}
