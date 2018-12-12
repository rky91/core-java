package com.corejava.thread.exectorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	public static void main(String[] args) {
		
		//For Scheduling of Tasks
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		//task to run after 10sec delay
		service.schedule(new Task(), 10, TimeUnit.SECONDS);
		
		//Task to run repeatedly every 10sec
		service.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);
		
		//Task to run repeatedly 10sec after previous task completes.
		service.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

	}

}
