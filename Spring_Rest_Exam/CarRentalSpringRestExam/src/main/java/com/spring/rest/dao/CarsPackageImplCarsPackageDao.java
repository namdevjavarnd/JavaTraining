package com.spring.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.entity.CarsPackage;

@Repository
public class CarsPackageImplCarsPackageDao implements CarsPackageDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void regCarsPackage(CarsPackage cp) {
		// TODO Auto-generated method stub
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(cp);

	}

	@Override
	public void upateCarsPackage(CarsPackage cp) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(cp);

		
	}

	@Override
	public int deleteCarsPackage(long cp) {
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from CarsPackage where id=:cp");
		theQuery.setParameter("id", cp);

		theQuery.executeUpdate();
		return 0;
	}

	@Override
	public CarsPackage getCarsPackageById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CarsPackage where id=?", CarsPackage.class);

		return null;
	}

	@Override
	public List<CarsPackage> getCarspackageByCar_Name(String car_name) {
		// TODO Auto-generated method stub
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query ... sort by Car name
				Query theQuery = currentSession.createQuery("from CarsPackage order by car_name", CarsPackage.class);

				// execute query and get result list
				List<CarsPackage> carsPackage = theQuery.getResultList();

				// return the results
				return carsPackage;
	}

	@Override
	public List<CarsPackage> getCarsPackageByCar_type(String car_type) {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by car type
		Query theQuery = currentSession.createQuery("from CarsPackage order by car_type", CarsPackage.class);

		// execute query and get result list
		List<CarsPackage> carsPackage = theQuery.getResultList();

		// return the results
		return carsPackage;
		
		
	}

	@Override
	public List<CarsPackage> getCarsPackageByDaily() {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by car package by daily
		Query theQuery = currentSession.createQuery("from CarsPackage order by daily", CarsPackage.class);

		// execute query and get result list
		List<CarsPackage> carsPackage = theQuery.getResultList();

		// return the results
		return carsPackage;
	}

	@Override
	public List<CarsPackage> getCarsPackageByWeekly() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by car package by weekly
		Query theQuery = currentSession.createQuery("from CarsPackage order by weekly", CarsPackage.class);

		// execute query and get result list
		List<CarsPackage> carsPackage = theQuery.getResultList();

		// return the results
		return carsPackage;
	}

	@Override
	public List<CarsPackage> getCarsPackageByMonthly() {
		// TODO Auto-generated method stub
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query ... sort by car package by weekly
				Query theQuery = currentSession.createQuery("from CarsPackage order by monthly", CarsPackage.class);

				// execute query and get result list
				List<CarsPackage> carsPackage = theQuery.getResultList();

				// return the results
				return carsPackage;
	}
    @Transactional
	@Override
	public List<CarsPackage> getAllCarsPackage() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CarsPackage", CarsPackage.class);
		List<CarsPackage> carsPackage = query.getResultList();
		return carsPackage;

	}

//	public int regCarsPackage(CarsPackage cp) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int upateCarsPackage(CarsPackage cp) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int deleteCarsPackage(CarsPackage cp) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public CarsPackage getCarsPackageById(int id) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from CarsPackage where id=?", CarsPackage.class);
//		return null;
//		
//	}
//
//	public List<CarsPackage> getCarspackageByCar_Name() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CarsPackage> getCarsPackageByCar_type() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CarsPackage> getCarsPackageByDaily() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CarsPackage> getCarsPackageByWeekly() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<CarsPackage> getCarsPackageByMonthly() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Transactional
//	public List<CarsPackage> getAllCarsPackage() {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from CarsPackage", CarsPackage.class);
//		List<CarsPackage> carsPackage = query.getResultList();
//		return carsPackage;
//	}

}
