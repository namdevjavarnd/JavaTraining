package com.spring.boot.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.ClassInfo;
@Repository
public class ClassDaoImpl implements ClassDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<ClassInfo> getClassInfo() {
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<ClassInfo> theQuery = currentSession.createQuery("from ClassInfo by Name", ClassInfo.class);

		// execute query and get result list
		List<ClassInfo> classIfo = theQuery.getResultList();

		// return the results
		return classIfo;	
	}



//	@Override
//	public ClassInfo getClassInfoById(int theId) {
//		// get the current hibernate session
//				Session currentSession = sessionFactory.getCurrentSession();
//
//				// now retrieve/read from database using the primary key
//				ClassInfo cls = currentSession.get(ClassInfo.class, theId);
//
//				return cls;
//	}

	

	@Override
	public ClassInfo saveClass(ClassInfo classInfo) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(classInfo);
		return classInfo;

	}

	@Override
	public ClassInfo getClassInfoById(Integer id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		ClassInfo cls = currentSession.get(ClassInfo.class, id);

		return cls;
	}

	@Override
	public void deleteClass(Integer id) {
		// TODO Auto-generated method stub

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from ClassInfo where id=:Id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();
	}
		
	}


