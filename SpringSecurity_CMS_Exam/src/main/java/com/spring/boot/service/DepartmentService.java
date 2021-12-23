package com.spring.boot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.spring.boot.model.ClassInfo;
import com.spring.boot.model.Department;
@Service
public interface DepartmentService {

	List<Department> getAllDepartment();

	Department saveDepartment(Department dept);

	Department getDepartmentById(Integer id);

	Department updateDepartment(Department dept);

	void deleteById(Integer id);

}
