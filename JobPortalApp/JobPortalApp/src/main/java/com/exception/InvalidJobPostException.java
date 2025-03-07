package com.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidJobPostException extends Exception {
	public InvalidJobPostException() {
		
	}
}
