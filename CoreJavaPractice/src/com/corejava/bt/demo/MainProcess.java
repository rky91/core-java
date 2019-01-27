package com.corejava.bt.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProcess {

	public static void main(String[] args) {
		
		System.out.println("Main rocess started....");
		BlockingQueue<Process> processBlockingQueue = new ArrayBlockingQueue<Process>(10);
		int coreCounter = Runtime.getRuntime().availableProcessors(); //Check for the no of processor available
		ExecutorService service = Executors.newFixedThreadPool(coreCounter);
		
		ProcessProducer processProducer = new ProcessProducer(processBlockingQueue);
		ProcessConsumer processConsumer = new ProcessConsumer(processBlockingQueue, service);
		
		new Thread(processProducer).start();
		new Thread(processConsumer).start();
		
		

	}

}
