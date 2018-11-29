package com.corejava.collections.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> empList = new ArrayList<>();
		empList = Arrays.asList(new Employee("Rakesh", "Jena", 26, 40000L),
					new Employee("Sampa", "Bhowmick", 27, 70000),
					new Employee("Hritish", "Samal", 8, 0),
					new Employee("Ankur", "Mishra", 25, 41000));
		
		empList.forEach(System.out :: println);
		
		Collections.sort(empList);
		System.out.println("After sorting with Comaprable.....");
		empList.forEach(System.out :: println);
		
		
		
		Collections.sort(empList, Employee.SalaryComparator);
		System.out.println("After sorting with Comaprator for Salary.....");
		empList.forEach(System.out :: println);
		

	}
	
}
