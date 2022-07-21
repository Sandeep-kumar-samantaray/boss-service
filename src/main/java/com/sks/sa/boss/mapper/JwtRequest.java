package com.sks.sa.boss.mapper;

import java.io.Serializable;


public class JwtRequest implements Serializable {
	
	private Long userId;
	private String password;
	
	private JwtRequest(Long userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	public Long getUserId() {
		return userId;
	}
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
	public String getPassword() {
		return password;
	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
	

}
