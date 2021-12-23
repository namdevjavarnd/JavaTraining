package com.spring.boot.dao;

import java.util.List;

import com.spring.boot.model.Student;

public interface StudentDao {
	List<Student> getAllStudent();
	
	public Student saveStudent(Student student);
		
	public Student getStudentById(Integer id);
		
	public Student updateStudent(Student student);
		
	public	void deleteStudentById(Integer id);

}
