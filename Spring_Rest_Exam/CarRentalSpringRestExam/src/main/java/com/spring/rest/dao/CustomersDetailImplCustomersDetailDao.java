package com.spring.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.CarsPackage;
import com.spring.rest.entity.CustomersDetail;

@Repository
public class CustomersDetailImplCustomersDetailDao implements CustomersDetailDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CustomersDetail getCustomerById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CustomersDetail where id=?", CustomersDetail.class);
		return null;
	}

	@Override
	public void regCustomer(CustomersDetail cx) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(cx);
	

	}

	@Override
	public void upateCustomer(CustomersDetail cx) {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(cx);
		
	}

	@Override
	public int deleteCustomer(CustomersDetail cx) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from CustomersDetail where id=:id");
		theQuery.setParameter("id", cx);

		theQuery.executeUpdate();
		return 0;

	}

	@Override
	public List<CustomersDetail> getCarspackageByCustomer_Name() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query theQuery = currentSession.createQuery("from CustomersDetail order by customer_name",
				CustomersDetailDao.class);

		// execute query and get result list
		List<CustomersDetail> customerDetails = theQuery.getResultList();

		// return the results
		return customerDetails;
	}

	@Override
	public List<CustomersDetail> getCustomerByCustomer_Contact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarsPackage> getCustomerByCustomer_Address() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomersDetail> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CustomersDetail", CustomersDetail.class);
		List<CustomersDetail> customersdetail = query.getResultList();
		return customersdetail;
	}

}

//	public int regCustomer(CustomersDetail cx) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int upateCustomer(CustomersDetail cx) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int deleteCustomer(CustomersDetail cx) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public CustomersDetail getCustomerById(int id) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from CustomersDetail where id=?", CustomersDetail.class);
//		return null;
//	}
//
//	public List<CustomersDetail> getCarspackageByCustomer_Name() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CustomersDetail> getCustomerByCustomer_Contact() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CarsPackage> getCustomerByCustomer_Address() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CustomersDetail> getAllCustomers() {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from CustomersDetail", CustomersDetail.class);
//		List<CustomersDetail> customersdetail = query.getResultList();
//		return customersdetail;
//	}

//
