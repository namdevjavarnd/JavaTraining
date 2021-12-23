package com.core.phonebook.model;

public class Phonebook {
	int id;
	String name;
	String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Phonebook [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
