package com.spring.boot.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.Department;
import com.spring.boot.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Student> getAllStudent() {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Student> theQuery = currentSession.createQuery("from Student ", Student.class);

		// execute query and get result list
		List<Student> stud = theQuery.getResultList();

		// return the results
		return stud;	
	}

	@Override
	public Student saveStudent(Student student) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(student);
				return student;

	}

	@Override
	public Student getStudentById(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Student stud = currentSession.get(Student.class, id);

		return stud;
	}

	@Override
	public Student updateStudent(Student student) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(student);
		return student;

	}

	@Override
	public void deleteStudentById(Integer id) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// delete object with primary key
				Query theQuery = currentSession.createQuery("delete from Student where id=:Id");
				theQuery.setParameter("id", id);

				theQuery.executeUpdate();
			}

}
