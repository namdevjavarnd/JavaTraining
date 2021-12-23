package com.spring.boot.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
