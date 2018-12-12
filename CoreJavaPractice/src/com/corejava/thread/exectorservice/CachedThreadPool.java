package com.corejava.thread.exectorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * Author : Rakesh Jena
 * Email : rakeshkumar.jena91@yahoo.com
 *  
 *  */

public class CachedThreadPool {
	
	/* Notes: Cached Thread Pool
	 * 
	 * 1. Here we do not have fixed number of thread pool and also don't have Queue which holds the number of tasks.
	 * 2. Instead the queue is replaced with the synchronous queue which holds only 1 task.
	 * 3. So every time you submit a task, the synchronous queue hold the task and search for the any of the threads which
	 * 	  are already created and which are free to operate and execute that task.
	 * 4. If no thread is available or free, it will create a new thread and add to the the thread pool and asks to execute
	 * 	  that task.
	 * 
	 * 
	 * */

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();

		// Submit the task to the thread pool for execution
		for (int i = 0; i < 30; i++) {
			service.submit(new Task());
		}
		service.shutdown();
	}

}
