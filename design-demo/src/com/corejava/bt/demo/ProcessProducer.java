package com.corejava.bt.demo;

import java.util.concurrent.BlockingQueue;

/**
 * Author : Rakesh Jena
 * Email : rakeshkumar.jena91@yahoo.com
 * 
 * 
 * **/

public class ProcessProducer implements Runnable{
	
	private BlockingQueue<Process> processQueue;
	private int countFlag = 15;
	
	public ProcessProducer(BlockingQueue<Process> processQueue) {
		this.processQueue = processQueue;
	}

	@Override
	public void run() {
		
		
		//get the the "QUEUED" process from the DB
		
		for(long i=0;i<15;i++) {
			Process process = new Process(i, i+"-File", true);
			try {
				processQueue.put(process);
				System.out.println(process.getId() + "- Produced");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Process process = new Process(false);
		try {
			processQueue.put(process);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
