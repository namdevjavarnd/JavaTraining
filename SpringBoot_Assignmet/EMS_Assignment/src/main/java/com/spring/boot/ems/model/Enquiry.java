package com.spring.boot.ems.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Enquiry {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String message;
	private String phone;
	private String course;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	private ZonedDateTime closedDate;
	private ZonedDateTime createdDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ZonedDateTime getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(ZonedDateTime closedDate) {
		this.closedDate = closedDate;
	}
	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Enquiry [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", phone=" + phone
				+ ", course=" + course + ", closedDate=" + closedDate + ", createdDate=" + createdDate + "]";
	}
	public int getEnquiryById(int id2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
