package com.spring.rest.controller;

public class CustomerDetailsNotFound extends RuntimeException{

	public CustomerDetailsNotFound(String message, Throwable cause) {
		super(message, cause);

	}

	public CustomerDetailsNotFound(String message) {
		super(message);

	}

	public CustomerDetailsNotFound(Throwable cause) {
		super(cause);

	}
}