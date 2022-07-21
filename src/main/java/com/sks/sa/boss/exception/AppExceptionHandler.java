package com.sks.sa.boss.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = {AppException.class})
	public ResponseEntity<Object> handelRequestException(AppException e){
		ExceptionBean exceptionBean = new ExceptionBean(e.getMessage(), e.getCause(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(exceptionBean,HttpStatus.BAD_REQUEST);
	}

}
