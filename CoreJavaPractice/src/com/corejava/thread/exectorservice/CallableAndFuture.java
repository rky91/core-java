package com.corejava.thread.exectorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Author : Rakesh Jena
 * Email : rakeshkumar.jena91@yahoo.com
 *  
 *  */

public class CallableAndFuture {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<String> future = service.submit(new CallableTask());
		
		try {
			if(future.get() != null) { //Once the task is executed, then the future is 
									   //available, till the future is not available the main thread will be blocked
				System.out.println(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}

class CallableTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Task Executed.";
	}
	
}
