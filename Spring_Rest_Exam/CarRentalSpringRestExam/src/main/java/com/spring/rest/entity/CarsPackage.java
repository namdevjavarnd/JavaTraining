package com.spring.rest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.spring.rest.dao.*;

@Entity
public class CarsPackage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "carname")
	private String car_name;
	@Column(name = "cartype")
	private String car_type;
	@Column(name = "daily")
	private String daily;
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
	public String getDaily() {
		return daily;
	}
	public void setDaily(String daily) {
		this.daily = daily;
	}
	public String getWeekly() {
		return weekly;
	}
	public void setWeekly(String weekly) {
		this.weekly = weekly;
	}
	public String getMonthly() {
		return monthly;
	}
	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}
	public void setId() {
		this.id = id;
	}
	private String weekly;
	private String monthly;
	public int getId() {
		return id;
	}
	public CarsPackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static List<CarsPackageDao> getAllCarsPackage() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
}
