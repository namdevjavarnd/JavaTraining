package com.spring.rest.controller;

public class CarNotFoundException extends RuntimeException{

	public CarNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CarNotFoundException(String message) {
		super(message);

	}

	public CarNotFoundException(Throwable cause) {
		super(cause);

	}

}