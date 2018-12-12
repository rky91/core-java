package com.corejava.thread.exectorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaExecutorService1 {
	
	/* Notes : 
	 * 1. In java, one java thread is equal to 1 operating system thread.
	 * 2. In thread pool, it internally uses the Blocking queue. In this queue it keeps storing the tasks that you have submitted.
	 * 3. Example:
	 *  
	 * 	- If you created a Thread pool of size 10 and you have submitted 100 tasks to the to the ExecutorService,
	 * 	  then it stores all the 100 tasks in the Blocking queue.
	 *  - All the 10 threads in the thread pool execute the below two steps:
	 *  	a. Fetch the next task from the queue
	 *  	b. Execute the fetched task
	 *  - This will continue till the queue is empty.
	 * 
	 * 
	 * */

	public static void main(String[] args) {
		
		//Create Thread pool
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//Submit the task to the thread pool for execution
		for(int i=0; i<30; i++) {
			service.submit(new Task());
		}
		
		service.shutdown();
	}
}


class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("Task Completed.");
		
	}
	
}
