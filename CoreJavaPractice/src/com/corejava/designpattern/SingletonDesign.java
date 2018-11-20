package com.corejava.designpattern;

import java.lang.reflect.Constructor;

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
		
		
		//Reflection
		System.out.println("Using Reflection..");
		Class cls = Class.forName("com.corejava.designpattern.Singleton");
		Constructor<Singleton> cons = cls.getDeclaredConstructor();
		cons.setAccessible(true);
		Singleton s3 = cons.newInstance();
		
		print("S1", s1);
		print("S2", s2);
		print("S3", s3);
	}
	
	
	public static void print(String name, Singleton obj) {
		System.out.println(String.format("Object : %s , Hascode : %d", name, obj.hashCode()));
	}
	
	
}
