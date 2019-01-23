package com.corejava.designpattern;

import java.lang.reflect.Constructor;
import java.util.stream.Stream;

class Singleton{
	
	private static Singleton singleton = null;
	
	private Singleton() {
		System.out.println("New Instance Created.");
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}


class SingletonDesign{
	
	
	public static void main(String args[]) throws Exception {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		
		//Reflection : by reflection we can break the singleton design patter as below
		System.out.println("Using Reflection..");
		Class cls = Class.forName("com.corejava.designpattern.Singleton");
		Constructor<Singleton> cons = cls.getDeclaredConstructor();
		cons.setAccessible(true); // Now we have the access to the private constructor
		Singleton s3 = cons.newInstance();
		
		print("S1", s1);
		print("S2", s2);
		print("S3", s3);
		
		//To address this reflection issue we have to check if the sole instance is null or not, if its null the create new instance
		// else return the old instance.
	}
	
	
	public static void print(String name, Singleton obj) {
		System.out.println(String.format("Object : %s , Hascode : %d", name, obj.hashCode()));
	}
	
	
}
