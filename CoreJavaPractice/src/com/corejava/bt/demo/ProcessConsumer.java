package com.corejava.bt.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;


public class ProcessConsumer implements Runnable{
	
	private BlockingQueue<Process> processQueue;
	private ExecutorService service;
	
	public ProcessConsumer(BlockingQueue<Process> processQueue, ExecutorService service) {
		System.out.println("ProcessConsumer constructor called **********************************************");
		this.processQueue = processQueue;
		this.service = service;
	}

	@Override
	public void run() {
		
		try {
			
			Process process;
			while((process = processQueue.take()).isFlag()) {
				Thread.sleep(120);
				System.out.println(process.getId() + "---------> Consumed");
				service.submit(new Task());
			}
			
		} catch (InterruptedException e) {
			
		} finally {
			service.shutdown();
		}
		
	}

}

class Task implements Runnable{

	@Override
	public void run() {
		
		//System.out.println("Task Completed." + Thread.currentThread().getName());
		
	}
	
}
