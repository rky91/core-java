package com.corejava.designpattern.factorymethod;

public class TextFIleParser implements BatchSigneture {

	@Override
	public void process(String file) {
		
		System.out.println("Test File Processed : "+file);

	}

}
