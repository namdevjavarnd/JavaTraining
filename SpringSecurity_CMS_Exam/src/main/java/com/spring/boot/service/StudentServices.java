package com.spring.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.model.ClassInfo;
import com.spring.boot.model.Student;
@Service
public interface StudentServices {
	
List<Student> getAllStudent();
	
public Student saveStudent(Student student);
	
public Student getStudentById(Integer id);
	
public Student updateStudent(Student student);
	
public	void deleteStudentById(Integer id);
}
