package com.simplilearn.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO :: WAP for CRUD Operations on user entity
	
//Along with proper Exception Handling 
@Entity
@Table(name="usertable")
public class User {

	//1. Write the private fields
	@Id  //<----Specify primary key
	@GeneratedValue(strategy=GenerationType.AUTO)   //To Make It Auto-generated 
	private long id;
	
	@Column(name="user_fullName")
	private String name;
	

	@Column(name="user_email")
	private String email;
	

	@Column(name="user_name")
	private String username;
	

	@Column(name="user_gender")
	private String gender;
	

	@Column(name="user_age")
	private int age;


	//2. Generate parameterized constructor
	public User(long id, String name, String email, String username, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.gender = gender;
		this.age = age;
	}
    

	//3. Generate non-parameterized constructor
	public User() { }



	//4. Generate Getter and Setter
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	//5. Generate ToString Method
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", gender="
				+ gender + ", age=" + age + "]";
	}
	
}
