package com.spring.boot.ems.controller;

public class EnquiryNotFoundException extends RuntimeException{

	public EnquiryNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public EnquiryNotFoundException(String message) {
		super(message);

	}

	public EnquiryNotFoundException(Throwable cause) {
		super(cause);

	}

}
