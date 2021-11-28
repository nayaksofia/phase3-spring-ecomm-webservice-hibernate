package com.simplilearn.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeetable")
public class Employee {
	
	//TODO :: WAP for CRUD Operations on employee entity
	
	//1. Write Private Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_gender")
	private String gender;
	
	@Column(name="emp_email")
	private String email;
	
	@Column(name="emp_dept")
	private String dept;
	
	@Column(name="emp_age")
	private int age;
	
	@Column(name="emp_salary")
	private double salary;

	

	//2. Parameterized Constructor
	public Employee(long id, String name, String gender, String email, String dept, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.dept = dept;
		this.age = age;
		this.salary = salary;
	}
	
	
	//3. Non-Parameterized Constructor
	public Employee() { }


	//4. Generate getter and setter
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	//5. Generate toString Method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", dept=" + dept
				+ ", age=" + age + ", salary=" + salary + "]";
	}
		

}
