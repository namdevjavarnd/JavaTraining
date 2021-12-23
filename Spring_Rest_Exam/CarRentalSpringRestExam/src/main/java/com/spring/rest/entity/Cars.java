package com.spring.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Cars {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String car_name;
	
	@Column(name = "C_T")
	private String car_type;
	@Column(name = "price / km")
	private int priceperkm;
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public int getPriceperkm() {
		return priceperkm;
	}
	public void setPriceperkm(int priceperkm) {
		this.priceperkm = priceperkm;
	}
	public void setId() {
		this.id = id;
	}
	public int getId() {
		return id;
}
	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Cars [id=" + id + ", car_name=" + car_name + ", car_type=" + car_type + ", priceperkm=" + priceperkm
				+ "]";
	}
}
