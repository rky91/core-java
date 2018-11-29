package com.corejava.designpattern.factorymethod;

public class XmlFIleParser implements BatchSigneture {

	@Override
	public void process(String file) {

		System.out.println("XML File Processed : "+file);
	}

}
