package com.spring.boot.dao;

import java.util.List;

import com.spring.boot.model.Teacher;

public interface TeacherDao {
	List<Teacher> getAllTeacher();
	
	Teacher saveTeacher(Teacher teacher);
		
	Teacher getTeacherById(Integer id);
		
	Teacher updateTeacher(Teacher teacher);
		
		void deleteTeacherById(Integer id);
}
