package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dao.TeacherDao;
import com.spring.boot.model.Teacher;
import com.spring.boot.repository.test.TeacherRepository;
@Service
public class TeacherServiceImpl implements TeacherService {

	  @Autowired
		private TeacherDao teacherDao;
		
//		public TeacherServiceImpl(TeacherRepository teacherRepository) {
//			super();
//			this.teacherRepository = teacherRepository;
//		}
		
		@Override
		@Transactional
		public List<Teacher> getAllTeacher() {
			// TODO Auto-generated method stub
			return teacherDao.getAllTeacher();
		}

		@Override
		@Transactional
		public Teacher saveTeacher(Teacher teacher) {
			return teacherDao.saveTeacher(teacher);
		}

		@Override
		public Teacher getTeacherById(Integer id) {
			// TODO Auto-generated method stub
			return teacherDao.getTeacherById(id);
		}

		@Override
		@Transactional
		public Teacher updateTeacher(Teacher teacher) {
			// TODO Auto-generated method stub
			return teacherDao.updateTeacher(teacher);
		}

		@Override
		@Transactional
		public void deleteTeacherById(Integer id) {
			teacherDao.deleteTeacherById(id);	
			
		}

}
