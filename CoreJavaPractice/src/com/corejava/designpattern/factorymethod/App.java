package com.corejava.designpattern.factorymethod;

public class App {
	
	public static void main(String[] args) {
		BatchProcess batchProcess = new BatchProcess();
		String file = "xml";
		BatchSigneture batchSigneture = BatchProcessFactory.createBatchProcessor(file);
		batchProcess.doProcess(file, batchSigneture);
		
	}

}
