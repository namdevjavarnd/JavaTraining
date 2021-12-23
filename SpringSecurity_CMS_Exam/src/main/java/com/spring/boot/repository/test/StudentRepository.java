package com.spring.boot.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {





}
