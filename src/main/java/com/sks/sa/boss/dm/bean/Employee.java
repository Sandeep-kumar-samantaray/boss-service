package com.sks.sa.boss.dm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Employee extends RowDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5625857974685923148L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "emp_id")
	@JsonProperty(value = "employeeId")
	private Long employeeId;
	
	@Column(name = "first_name")
	@JsonProperty(value = "firstName")
	private String firstName;
	
	@Column(name = "last_name")
	@JsonProperty(value = "lastName")
	private String lastName;
	
	@Column(name = "email")
	@JsonProperty(value = "email")
	private String email;
	
	@Column(name = "gender")
	@JsonProperty(value = "gender")
	private String gender;
	
	@Column(name = "password")
	@JsonProperty(value = "password")
	private String password;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
