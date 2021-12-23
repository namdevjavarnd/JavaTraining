package com.core.phonebook.exception;

public class DuplicateNameException extends Exception{

	String name;
	public DuplicateNameException(String p) {
		name = p;
	}
	public String toString() {
		return (name+": Name Already Exists");
	}
}
