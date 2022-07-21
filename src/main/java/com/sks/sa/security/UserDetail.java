package com.sks.sa.security;

import java.io.Serializable;

public class UserDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1627328559058916815L;
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	private UserDetail() {
		
	}
	
	public UserDetail(Long userId, String firstName, String lastName, String password, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	public static UserDetail getDetails() {
		return new UserDetail();
	}
	
	
	
	
	
	

}
