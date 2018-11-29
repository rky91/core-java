package com.corejava.designpattern.factorymethod;

public class App {
	
	public static void main(String[] args) {
		BatchProcess batchProcess = new BatchProcess();
		String file = "xml";
		BatchSigneture batchSigneture = createBatchProcessor(file);
		batchProcess.doProcess(file, batchSigneture);
		
	}

	private static BatchSigneture createBatchProcessor(String file) {
		
		if(file.equalsIgnoreCase("text")) {
			return new TextFIleParser();
		} else if(file.equalsIgnoreCase("xml")) {
			return new XmlFIleParser();
		} else
			return null;
	}

}
