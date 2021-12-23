package com.core.phonebook.exception;

public class DuplicateNumberException extends Exception{

	String phone;
	public DuplicateNumberException(String p) {
		phone = p;
	}
	public String toString() {
		return (phone+": Number Already Exists");
	}
}
