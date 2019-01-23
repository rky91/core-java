package com.corejava.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class ConsumerThread implements Runnable {

private BlockingQueue<Message> queue;
	
	public ConsumerThread(BlockingQueue<Message> queue) {
		this.queue = queue;
	}
	
	
	@Override
	public void run() {
		
		try {
			
			Message msg;
			while(!(msg=queue.take()).getMessage().equalsIgnoreCase("Exit") ) {
				Thread.sleep(120);
				System.out.println("Consumed == "+msg);
			}
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

	}

}
