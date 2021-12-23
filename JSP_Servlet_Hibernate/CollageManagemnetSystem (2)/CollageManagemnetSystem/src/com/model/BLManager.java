package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.pojo.ClassInfo;
import com.pojo.Department;
import com.pojo.Student;
import com.pojo.Teacher;

public class BLManager {
	SessionFactory con = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

	public void save(Object d) {

		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		session.save(d);
		t.commit();
		session.close();
	}

	public List<Department> viewAllDepartment() {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Department.class);
		List<Department> d = cr.list();
		s.close();
		return d;
	}

	public Department searchByDepartmentId(int deptId) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Department.class);
		cr.add(Restrictions.eq("id", deptId));
		Department d = (Department) cr.uniqueResult();
		session.close();
		return d;
	}

	public ClassInfo searchByClassId(int classId) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(ClassInfo.class);
		cr.add(Restrictions.eq("id", classId));
		ClassInfo d = (ClassInfo) cr.uniqueResult();
		session.close();
		return d;
	}

	public void update(Object d) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		session.update(d);
		t.commit();
		session.close();
	}

	public void delete(Object d) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		session.delete(d);
		t.commit();
		session.close();
	}

	public List<ClassInfo> viewAllClasses() {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(ClassInfo.class);
		List<ClassInfo> d = cr.list();
		s.close();
		return d;
	}

	public Department searchByDepartmentName(String name) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Department.class);
		cr.add(Restrictions.eq("name", name));
		Department d = (Department) cr.uniqueResult();
		session.close();
		return d;
	}

	public ClassInfo searchByClassName(String name) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(ClassInfo.class);
		cr.add(Restrictions.eq("name", name));
		ClassInfo d = (ClassInfo) cr.uniqueResult();
		session.close();
		return d;
	}

	public List<Teacher> viewAllTeachers() {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Teacher.class);
		List<Teacher> d = cr.list();
		s.close();
		return d;
	}

	public Teacher searchByTeacherId(int techId) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Teacher.class);
		cr.add(Restrictions.eq("id", techId));
		Teacher d = (Teacher) cr.uniqueResult();
		session.close();
		return d;
	}
	
	public List<Student> viewAllStudent() {
		Session s = con.openSession();
		Criteria cr = s.createCriteria(Student.class);
		List<Student> d = cr.list();
		s.close();
		return d;
	}
	
	public Student searchByStudentId(int stdId) {
		Session session = con.openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Student.class);
		cr.add(Restrictions.eq("id", stdId));
		Student d = (Student) cr.uniqueResult();
		session.close();
		return d;
	}

}
