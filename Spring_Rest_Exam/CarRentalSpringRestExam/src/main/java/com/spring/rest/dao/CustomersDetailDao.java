package com.spring.rest.dao;

import java.util.List;

import com.spring.rest.entity.CarsPackage;
import com.spring.rest.entity.CustomersDetail;

public interface CustomersDetailDao {
	public void regCustomer(CustomersDetail cx);

	public void upateCustomer(CustomersDetail cx);

	public int deleteCustomer(CustomersDetail cx);

	public CustomersDetail getCustomerById(int id);

	public List<CustomersDetail> getCarspackageByCustomer_Name();

	public List<CustomersDetail> getCustomerByCustomer_Contact();
	
	public List<CarsPackage> getCustomerByCustomer_Address();
	
	
	public List<CustomersDetail> getAllCustomers();

//	public void setId();
//
//	public void setcustomer_name(String string);
//
//	public void setcustomer_contact(String string);
//
//	public void setcustomer_address(String string);
//
//	public char[] getcustomer_name();
}

