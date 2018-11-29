package com.corejava.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class UnitExcerciseWithLambda {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
					new Person("XF", "XL", 22),
					new Person("ZF", "ZL", 21),
					new Person("YF", "YL", 24),
					new Person("YF", "YL1", 25),
					new Person("AF", "AL", 20)
				);
		
		//step : Sort list by first Name
		
		Collections.sort(personList, (o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()));
			
		
		//step-2 : Create a method that prints all the elements in the list
		
		printListWithFilter(personList, p -> true);
		
		
		//Step-2 : Create a method that prints all the people having last name begins with Y
		
		printListWithFilter(personList, p -> p.getLastName().startsWith("Y"));
		
	}
	
	//Here Predicate<T> is a out of box interface with is present in java.util.function package
	public static void printListWithFilter(List<Person> personList, Predicate<Person> con) {
		
		System.out.println("=========== printListWithFilter ==========");
		
		personList.forEach(p -> {
			if(con.test(p))
			System.out.println(p.toString());
		});
		
	}
	

}
























