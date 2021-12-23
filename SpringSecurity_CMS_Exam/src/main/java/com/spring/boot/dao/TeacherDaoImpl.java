package com.spring.boot.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.Department;
import com.spring.boot.model.Teacher;
@Repository
public class TeacherDaoImpl implements TeacherDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Teacher> getAllTeacher() {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Teacher> theQuery = currentSession.createQuery("from Teacher ", Teacher.class);

		// execute query and get result list
		List<Teacher> teacher = theQuery.getResultList();

		// return the results
		return teacher;	
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(teacher);
				return teacher;

	}

	@Override
	public Teacher getTeacherById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Teacher teacher = currentSession.get(Teacher.class, id);

		return teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(teacher);
		return teacher;
	}

	@Override
	public void deleteTeacherById(Integer id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Teacher where id=:Id");
		theQuery.setParameter("id", id);

		theQuery.executeUpdate();
	}

}
