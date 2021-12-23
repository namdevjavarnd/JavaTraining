package com.spring.rest.controller;

public class CarsPackageNotFoundException extends RuntimeException {

	
	public CarsPackageNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CarsPackageNotFoundException(String message) {
		super(message);

	}

	public CarsPackageNotFoundException(Throwable cause) {
		super(cause);

	}
}
