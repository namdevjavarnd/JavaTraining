package com.spring.boot.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.ems.dao.EnquiryDao;
import com.spring.boot.ems.model.Enquiry;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	@Autowired
	private EnquiryDao enquiryDao;
	@Override
	public void save(Enquiry eq) {
		// TODO Auto-generated method stub
		enquiryDao.save(eq);
	}

	@Override
	@Transactional
	public void upate(Enquiry eq) {
		// TODO Auto-generated method stub
		enquiryDao.save(eq);
		
	}

	@Override
	@Transactional
	public int deleteEnquiry(long id) {
		// TODO Auto-generated method stub
		
		return enquiryDao.deleteEnquiry(id);
	}

	@Override
	@Transactional
	public int getEnquiryById(int id) {
		// TODO Auto-generated method stub
		return  enquiryDao.getEnquiryById(id);
	}

	@Override
	@Transactional
	public List<Enquiry> getByName() {
		// TODO Auto-generated method stub
		return enquiryDao.getByName();
	}

	@Override
	@Transactional
	public List<Enquiry> getAllEnquiry() {
		// TODO Auto-generated method stub
		return enquiryDao.getAllEnquiry();
	}

	@Override
	public List<Enquiry> getEnquiryByName(String name) {
		// TODO Auto-generated method stub
		return enquiryDao.getEnquiryByName(name);
	}

	
	

}
