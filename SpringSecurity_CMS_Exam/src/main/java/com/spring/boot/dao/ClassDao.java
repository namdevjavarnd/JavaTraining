package com.spring.boot.dao;

import java.util.List;

import com.spring.boot.model.ClassInfo;

public interface ClassDao {

	public List<ClassInfo> getClassInfo();

	public ClassInfo saveClass(ClassInfo classInfo);

	public ClassInfo getClassInfoById(Integer id);

	public void deleteClass(Integer id);

	
}
