package com.spring.boot.ems.service;

import java.util.List;

import com.spring.boot.ems.model.Enquiry;

public interface EnquiryService {
	public void save(Enquiry eq);

	public void upate(Enquiry cars);

	public int deleteEnquiry(long id);

	public int getEnquiryById(int id);

	public List<Enquiry> getByName();

	public List<Enquiry> getAllEnquiry();

	List<Enquiry> getEnquiryByName(String name);

	
}
