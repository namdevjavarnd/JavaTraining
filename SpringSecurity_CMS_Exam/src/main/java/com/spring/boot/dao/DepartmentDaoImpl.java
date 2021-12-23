package com.spring.boot.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.ClassInfo;
import com.spring.boot.model.Department;
@Repository
public class DepartmentDaoImpl implements DepartmentDao{

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Department> getAllDepartment() {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Department> theQuery = currentSession.createQuery("from Department by Name", Department.class);

		// execute query and get result list
		List<Department> dept = theQuery.getResultList();

		// return the results
		return dept;	
	}

	@Override
	public Department saveDepartment(Department dept) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(dept);
		return dept;

	}

	@Override
	public Department getDepartmentById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Department dept = currentSession.get(Department.class, id);

		return dept;
	}

	@Override
	public Department updateDepartment(Department dept) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(dept);
		return dept;

	}

	@Override
	public void deleteById(Integer id) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// delete object with primary key
				Query theQuery = currentSession.createQuery("delete from Department where id=:Id");
				theQuery.setParameter("id", id);

				theQuery.executeUpdate();
			}
}
