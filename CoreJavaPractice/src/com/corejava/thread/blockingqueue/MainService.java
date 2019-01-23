package com.corejava.thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainService {

	public static void main(String[] args) {
		
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);
		
		ProducerThread producer = new ProducerThread(queue);
		ConsumerThread consumer = new ConsumerThread(queue);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		
		
	}

}
