package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dao.ClassDao;
import com.spring.boot.model.ClassInfo;
import com.spring.boot.repository.test.ClassInfoRepository;

@Service
public class ClassInfoServiceImpl implements ClassInfoService{
     @Autowired
	private ClassDao classDao;
	

	@Override
	@Transactional
	public List<ClassInfo> getAllClassInfo() {
		// TODO Auto-generated method stub
		return classDao.getClassInfo();
	}

	@Override
	@Transactional
	public ClassInfo saveClass(ClassInfo classInfo) {
		return classDao.saveClass(classInfo);
	}

	@Override
	@Transactional
	public ClassInfo getClassById(Integer id) {
		// TODO Auto-generated method stub
		return classDao.getClassInfoById(id);
	}

	@Override
	@Transactional
	public ClassInfo updateClass(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		return classDao.saveClass(classInfo);
	}


	@Override
	@Transactional
	public ClassInfo deleteClassById(Integer id) {
		classDao.deleteClass(id);
		return null;	
		
	}


	

}
