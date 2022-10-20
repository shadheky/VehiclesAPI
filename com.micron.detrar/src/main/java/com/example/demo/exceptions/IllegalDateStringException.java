package com.example.demo.exceptions;

public class IllegalDateStringException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public IllegalDateStringException(String msg) {
		
		super(msg);
	}
}
