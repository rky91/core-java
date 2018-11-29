package com.corejava.designpattern.factorymethod;

public class BatchProcess {
	
	
	public final void doProcess(String file, BatchSigneture bs) {
		
		//open file
		
		openFile(file);
		
		//process file
		
		processFile(bs, file);
		
		//close file
		
		closeFile(file);
		
		//process summary
		
		summary();
	}

	private void summary() {
		System.out.println("Completed");
		
	}

	private void closeFile(String file) {
		System.out.println("File Closed");
		
	}

	private void processFile(BatchSigneture bs, String file) {
		bs.process(file);
		System.out.println("File processed");
	}

	private void openFile(String file) {
		System.out.println("File opened");
	}
	
	

}
