package com.spring.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.entity.Cars;

@Repository
public class CarsImpCars implements CarsDao {
	@Autowired
	private SessionFactory sessionFactory;
    @Override
	public void regCars(Cars cars) {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(cars);

		
	}
  
	@Override
	@Transactional
	public int deleteCars(long id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Cas where id=:id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();
		return 0;
	}
	@Override
	@Transactional
	public void upateCars(Cars cars) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(cars);

		
	}
	@Override
	@Transactional
	public int getCarById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cars where id=?", Cars.class);
		return ((CarsImpCars) session).getCarById(id);

	}

	@Override
	@Transactional
	public List<Cars> getCarByCar_type(String car_type) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from cars where car_type=?", Cars.class);
		return null;

	}
	@Override
	@Transactional
	public List<Cars> getAllCars() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cars", Cars.class);
		List<CarsDao> cars = query.getResultList();

		return null;
	}

	
	@Override
	public List<Cars> getCarByCar_Name(String car_name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from cars where car_name=?", Cars.class);
		return null;
	}

	@Override
	public int deleteCars(Cars cars) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	

	
	}

	

