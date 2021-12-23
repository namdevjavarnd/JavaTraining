package com.spring.boot.ems.dao;

import java.util.List;

import com.spring.boot.ems.model.Enquiry;



public interface EnquiryDao {

	
	public void save(Enquiry eq);

	public void upate(Enquiry cars);

	public int deleteEnquiry(long id);

	public int getEnquiryById(int id);

	public List<Enquiry> getByName();

	public List<Enquiry> getAllEnquiry();

	List<Enquiry> getEnquiryByName(String name);

	

}
