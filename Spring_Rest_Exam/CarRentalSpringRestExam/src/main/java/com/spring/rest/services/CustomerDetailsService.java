package com.spring.rest.services;

import java.util.List;

import com.spring.rest.dao.CustomersDetailDao;
import com.spring.rest.entity.CarsPackage;
import com.spring.rest.entity.CustomersDetail;

public interface CustomerDetailsService {
	public void regCustomer(CustomersDetail cx);

	public void upateCustomer(CustomersDetail cx);

	public int deleteCustomer(long l);

	public CustomersDetail getCustomerById(int id);

	public List<CustomersDetail> getCarspackageByCustomer_Name();

	public List<CustomersDetail> getCustomerByCustomer_Contact();
	
	public List<CarsPackage> getCustomerByCustomer_Address();
	
	
	public List<CustomersDetail> getAllCustomers();

	int deleteCustomer(CustomersDetail cx);

	//void regCustomer(CustomersDetail cx);

}
