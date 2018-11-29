package com.corejava.collections.compare;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	
	private String fname;
	private String lname;
	private int age;
	private long salary;
	
	public Employee() {}
	
	public Employee(String fname, String lname, int age, long salary) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.salary = salary;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", age=" + age + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return (this.age - o.age);
	}
	
	public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return (int) (o1.getSalary() - o2.getSalary());
		}
	};
	
	
	public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getAge()-o2.getAge();
		}
	};
	
	public static Comparator<Employee> FnameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getFname().compareTo(o2.getFname());
		}
	};
	
}
