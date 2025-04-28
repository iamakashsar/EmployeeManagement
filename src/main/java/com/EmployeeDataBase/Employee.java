package com.EmployeeDataBase;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String phno;
	private double salary;
	
	public Employee(int id,String name,int age,String gender,String email,String phno,double salary) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.email=email;
		this.phno=phno;
		this.salary=salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getPhno() {
		return phno;
	}
	public double getSalary() {
		return salary;
	}
}
