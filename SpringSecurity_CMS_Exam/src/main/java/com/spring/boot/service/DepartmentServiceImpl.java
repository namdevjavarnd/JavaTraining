package com.spring.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dao.DepartmentDao;
import com.spring.boot.model.Department;
import com.spring.boot.repository.test.ClassInfoRepository;
import com.spring.boot.repository.test.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	
	 @Autowired
		private DepartmentDao departmentDao;
	 
//	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//		super();
//		this.departmentRepository = departmentRepository;
//	}

	@Override
	@Transactional
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentDao.getAllDepartment();
	}

	@Override
	@Transactional
	public Department saveDepartment(Department dept) {
		// TODO Auto-generated method stub
		return departmentDao.saveDepartment(dept);
		
	}


	@Override
	@Transactional
	public Department updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return departmentDao.updateDepartment(dept);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		departmentDao.deleteById(id);	
		
	}

//	@Override
	
//	public int getDepartmentById(Integer id) {
//		// TODO Auto-generated method stub
//		return  departmentRepository.getById(id).getId();
//	}
	@Override
	@Transactional
	public Department getDepartmentById(Integer id) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentById(id);
	}

	
	

	
}
