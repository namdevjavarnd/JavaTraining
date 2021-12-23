package com.spring.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.model.ClassInfo;
@Service
public interface ClassInfoService {
	
	
List<ClassInfo> getAllClassInfo();
	
ClassInfo saveClass(ClassInfo classInfo);
	

	
ClassInfo updateClass(ClassInfo classInfo);
	
	

	ClassInfo getClassById(Integer id);

	ClassInfo deleteClassById(Integer id);


}
