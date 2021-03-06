package com.corejava.lambda.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.corejava.lambda.unit1.Person;

public class StreamExample {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
				new Person("XF", "XL", 22),
				new Person("ZF", "ZL", 21),
				new Person("YF", "YL", 24),
				new Person("YF", "YL1", 25),
				new Person("AF", "AL", 20)
			);
		
		personList.stream()
		.filter(p -> p.getLastName().startsWith("Y"))
		.forEach(System.out::println); //method Reference Expression
		
		Map<Integer, Integer> demo = new ConcurrentHashMap<Integer, Integer>();
		
		demo.put(1, null);
		
		System.out.println(demo.get(1));
		
	}

}
