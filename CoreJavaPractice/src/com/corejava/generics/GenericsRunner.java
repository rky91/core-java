package com.corejava.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {

	public static void main(String[] args) {
		
		GenericUtil<String> list = new GenericUtil<>();
		list.addElement("Rakesh");
		list.addElement("Jena");
		System.out.println(list);
		
		
		GenericUtil<Integer> list2 = new GenericUtil<>();
		list2.addElement(Integer.valueOf(5));
		list2.addElement(Integer.valueOf(10));
		System.out.println(list2);
	}

}


class GenericUtil<T>{
	
	private List<T> list = new ArrayList<>();
	
	public void addElement(T ele) {
		list.add(ele);
	}
	
	public void removeElement(T ele) {
		list.remove(ele);
	}
	
	public String toString() {
		return list.toString();
	}
	
	
}
