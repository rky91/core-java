package com.corejava.designpattern.factorymethod;

public class BatchProcessFactory {

	public static BatchSigneture createBatchProcessor(String file) {
		
		if(file.equalsIgnoreCase("text")) {
			return new TextFIleParser();
		} else if(file.equalsIgnoreCase("xml")) {
			return new XmlFIleParser();
		} else
			return null;
	}
}
