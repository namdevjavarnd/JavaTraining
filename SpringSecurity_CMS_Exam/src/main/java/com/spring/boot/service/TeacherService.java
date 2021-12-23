package com.spring.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.model.Teacher;
@Service
public interface TeacherService {
	
List<Teacher> getAllTeacher();
	
Teacher saveTeacher(Teacher teacher);
	
Teacher getTeacherById(Integer id);
	
Teacher updateTeacher(Teacher teacher);
	
	void deleteTeacherById(Integer id);
}
