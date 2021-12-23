package com.spring.boot.ems.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.ems.model.Enquiry;


@Repository
public class EnquiryDaoImpl implements EnquiryDao {

	 @Autowired
		private SessionFactory sessionFactory;
	@Override
	@Transactional
	public void save(Enquiry eq) {
		
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(eq);
	}

	@Override
	@Transactional
	public void upate(Enquiry eq) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(eq);

	}

	@Override
	@Transactional
	public int deleteEnquiry(long id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Enquiry where id=:id");
		theQuery.setParameter("id", id);

		return	theQuery.executeUpdate();
		
	}

	@Override
	@Transactional
	public int getEnquiryById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Enquiry where id=?", Enquiry.class);
		return ((Enquiry) session).getEnquiryById(id);
	
	}

	@Override
	@Transactional
	public List<Enquiry> getByName() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Enquiry where name=?", Enquiry.class);
		return null;
	}

	@Override
	@Transactional
	public List<Enquiry> getAllEnquiry() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Enquiry", Enquiry.class);
		List<EnquiryDao> enquiryDao = query.getResultList();
		return getAllEnquiry();
		
	}

	@Override
	@Transactional
	public List<Enquiry> getEnquiryByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Enquiry", Enquiry.class);
		 List<EnquiryDao> eqdao = query.getResultList();
		 return null;
	}

	
}
