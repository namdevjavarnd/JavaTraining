package com.spring.rest.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomersDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "customerNname")
	private String customer_name;
	@Column(name = "customerContact")
	private int customer_contact;
	@Column(name = "customerAaddress")
	private String customer_address;
	@Column(name = "paymentMode")
	private String payment_mode;
	public int getId() {
		return id;
}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getCustomer_contact() {
		return customer_contact;
	}
	public void setCustomer_contact(int customer_contact) {
		this.customer_contact = customer_contact;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CustomersDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
}