package com.qa.gorest.pojo;


/**
 * POJO Template for User 
 * @author ASHUTOSH SINGH
 *
 */
public class User {
	
	private String name;
	private String email;
	private String gender;
	private String dob;
	private String status;
	
	public User(String name, String email, String gender, String dob, String status) {
		
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.status = status;
	}
	
	//getter and Setter method

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
