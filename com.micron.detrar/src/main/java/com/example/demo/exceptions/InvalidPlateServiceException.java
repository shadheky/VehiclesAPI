package com.example.demo.exceptions;

public class InvalidPlateServiceException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public InvalidPlateServiceException(String msg) {
		super(msg);
		
	}
	
}
