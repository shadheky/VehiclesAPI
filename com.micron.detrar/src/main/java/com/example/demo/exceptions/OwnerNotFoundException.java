package com.example.demo.exceptions;

public class OwnerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OwnerNotFoundException(String msg) {
		super(msg);
	}
}
