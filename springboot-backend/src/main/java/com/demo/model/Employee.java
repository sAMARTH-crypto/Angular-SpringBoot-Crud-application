package com.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "f_name")
	private String firstName;
	
	@Column(name = "l_name")
	private String lastName;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "department")
	private String department;

	
	
	
	public Employee() {
		
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee(long id, int age, String firstName, String lastName, String designation, String department) {
		super();
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.department = department;
	}

}
