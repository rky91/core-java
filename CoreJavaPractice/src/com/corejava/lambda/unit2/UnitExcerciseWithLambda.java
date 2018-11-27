package com.corejava.lambda.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.corejava.lambda.unit1.Person;

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
		
		performConditionally(personList, p -> true, p -> System.out.println(p));
		
		
		//Step-2 : Create a method that prints all the people having last name begins with Y
		
		performConditionally(personList, p -> p.getLastName().startsWith("Y"), p -> System.out.println(p.getFirstName()));
		
	}
	
	//Here Predicate<T> and Consumer<P> are the out of box interfaces which are present in java.util.function package
	public static void performConditionally(List<Person> personList, Predicate<Person> con, Consumer<Person> consumer) {
		
		System.out.println("=========== printListWithFilter ==========");
		
		personList.forEach(p -> {
			if(con.test(p))
				consumer.accept(p);
		});
		
	}
	

}
























