package com.in28minutes.database.databasedemo.resttempalte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
// summary 
// @Entity -> OR for table equivalant pojo
// @Table( name = "table name")
// @Id column for the unique column 
// @GeneratedValue(strategy = GenerationType.AUTO) auto increment sequence number 
// @Column signify the column name @Column(name = "first_name", nullable = false)
//javax validation reference in https://www.javacodegeeks.com/2018/08/spring-data-jpa-central-exception-handling-vo-validations-framework.html
import javax.validation.constraints.Size;




public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
	
}
