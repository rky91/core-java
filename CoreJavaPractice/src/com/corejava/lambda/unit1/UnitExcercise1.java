package com.corejava.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnitExcercise1 {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
					new Person("XF", "XL", 22),
					new Person("ZF", "ZL", 21),
					new Person("YF", "YL", 24),
					new Person("YF", "YL1", 25),
					new Person("AF", "AL", 20)
				);
		
		//step : Sort list by first Name
		
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
			}
		});
		
		//step-2 : Create a method that prints all the elements in the list
		
		printList(personList);
		
		
		//Step-2 : Create a method that prints all the people having last name begins with Y
		
		printListWithFilter(personList, new Condition() {
			
			@Override
			public boolean test(Person p) {
				if(p.getLastName().startsWith("Y")) {
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	
	public static void printList(List<Person> personList) {
		for(Person p : personList) {
			System.out.println(p.toString());
		}
	}
	
	
	public static void printListWithFilter(List<Person> personList, Condition con) {
		
		System.out.println("=========== printListWithFilter ==========");
		for(Person p : personList) {
			if(con.test(p))
			System.out.println(p.toString());
		}
	}
	

}

interface Condition{
	boolean test(Person p);
}
