package com.spring.boot.Controller;

public class ClasssInfoNotFoundException extends RuntimeException {

	public ClasssInfoNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public ClasssInfoNotFoundException(String message) {
		super(message);

	}

	public ClasssInfoNotFoundException(Throwable cause) {
		super(cause);

	}

}
