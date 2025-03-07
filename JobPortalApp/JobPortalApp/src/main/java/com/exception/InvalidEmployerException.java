package com.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidEmployerException  extends Exception {
	public InvalidEmployerException() {
		
	}
}
