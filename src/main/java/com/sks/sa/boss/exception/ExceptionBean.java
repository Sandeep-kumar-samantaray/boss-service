package com.sks.sa.boss.exception;

import org.springframework.http.HttpStatus;

public class ExceptionBean {
	
	private String errorMsg;
	
	private Throwable cause;
	
	private HttpStatus httpStatus;
	
	

	public ExceptionBean() {
		super();
	}



	public ExceptionBean(String errorMsg, Throwable cause, HttpStatus httpStatus) {
		super();
		this.errorMsg = errorMsg;
		this.cause = cause;
		this.httpStatus = httpStatus;
	}



	public String getErrorMsg() {
		return errorMsg;
	}



	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}



	public Throwable getErrorCode() {
		return cause;
	}



	public void setErrorCode(Throwable cause) {
		this.cause = cause;
	}



	public HttpStatus getHttpStatus() {
		return httpStatus;
	}



	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}


}
