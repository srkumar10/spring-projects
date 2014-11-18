package com.ouc.customerportal.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseErrorHandler {
	
	@ExceptionHandler(value={Exception.class, RuntimeException.class})
	public String handleDatabaseException(Exception e, RuntimeException re) {
		return "error";
	}

}
