package com.corejava.thread.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable {
	
	private BlockingQueue<Message> queue;
	
	public ProducerThread(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			try {
				Message msg = new Message(""+i);
				Thread.sleep(1100);
				queue.put(msg);
				System.out.println("Produces --> "+msg);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Message msg = new Message("Exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
