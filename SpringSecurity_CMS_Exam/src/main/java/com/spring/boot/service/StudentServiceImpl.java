package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.boot.dao.StudentDao;
import com.spring.boot.model.Student;
import com.spring.boot.repository.test.DepartmentRepository;
import com.spring.boot.repository.test.StudentRepository;
@Service
public class StudentServiceImpl implements StudentServices {

	 @Autowired
		private StudentDao studentDao;
	 

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.saveStudent(student);
	}



	     @Override
	 	@Transactional
		public Student updateStudent(@RequestBody Student student) {
			return ((StudentServiceImpl) this.studentDao).updateStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudentById(Integer id) {
		// TODO Auto-generated method stub
		studentDao.deleteStudentById(id);
	}
	@Override
	@Transactional
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(id);
	}

	
	

//	public Student updateStudent(Student student) {
//		// TODO Auto-generated method stub
//		return ((StudentServiceImpl) studetRepository).updateStudent(student);
	
//	@Override
//	public int getStudentById(Integer id) {
//		// TODO Auto-generated method stub
//		return  studetRepository.getById(id).getId();
//	}
	 
	
//	public StudentServiceImpl(StudentRepository studetRepository) {
//		super();
//		this.studetRepository = studetRepository;
//	}

	
}
