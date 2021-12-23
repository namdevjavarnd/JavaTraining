package com.spring.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.boot.model.Department;

public interface DepartmentDao {

	
	List<Department> getAllDepartment();

	Department saveDepartment(Department dept);

	Department getDepartmentById(Integer id);

	Department updateDepartment(Department dept);

	void deleteById(Integer id);
}
