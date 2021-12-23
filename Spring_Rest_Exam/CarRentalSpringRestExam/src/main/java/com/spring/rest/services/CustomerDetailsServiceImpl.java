package com.spring.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.dao.CustomersDetailDao;
import com.spring.rest.entity.CarsPackage;
import com.spring.rest.entity.CustomersDetail;
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
      
	@Autowired
	 private CustomersDetailDao customerDetailDao;
	
	@Override
	@Transactional
	public void regCustomer(CustomersDetail cx) {
		customerDetailDao.regCustomer(cx);
	}

	@Override
	public void upateCustomer(CustomersDetail cx) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	@Transactional
	public int deleteCustomer(CustomersDetail cx) {
		// TODO Auto-generated method stub
		customerDetailDao.deleteCustomer(cx);
		return 0;
	}

	@Override
	@Transactional
	public CustomersDetail getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDetailDao.getCustomerById(id);
	}

	@Override
	@Transactional
	public List<CustomersDetail> getCarspackageByCustomer_Name() {
		// TODO Auto-generated method stub
		return customerDetailDao.getCarspackageByCustomer_Name();
	}

	@Override
	@Transactional
	public List<CustomersDetail> getCustomerByCustomer_Contact() {
		// TODO Auto-generated method stub
		return customerDetailDao.getCustomerByCustomer_Contact();
	}

	@Override
	@Transactional
	public List<CarsPackage> getCustomerByCustomer_Address() {
		// TODO Auto-generated method stub
		return customerDetailDao.getCustomerByCustomer_Address();
	}

	@Override
	@Transactional
	public List<CustomersDetail> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDetailDao.getAllCustomers();

}

	@Override
	public int deleteCustomer(long l) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
