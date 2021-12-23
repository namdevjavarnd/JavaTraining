package com.spring.rest.dao;

import java.util.List;

import org.apache.xmlbeans.impl.jam.mutable.MPackage;

import com.spring.rest.entity.*;



public interface CarsPackageDao {
	
	public void regCarsPackage(CarsPackage cp);

	public void upateCarsPackage(CarsPackage cp);

	public int deleteCarsPackage(long cp);

	public CarsPackage getCarsPackageById(int id);

	public List<CarsPackage> getCarspackageByCar_Name(String car_name);

	public List<CarsPackage> getCarsPackageByCar_type(String car_type);
	
	public List<CarsPackage> getCarsPackageByDaily();
	
	public List<CarsPackage> getCarsPackageByWeekly();
	
	public List<CarsPackage> getCarsPackageByMonthly();

	public List<CarsPackage> getAllCarsPackage();
}
