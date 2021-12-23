package com.spring.rest.services;

import java.util.List;

import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.dao.CarsDao;
import com.spring.rest.dao.CarsPackageDao;
import com.spring.rest.entity.CarsPackage;

@Service
public class CarsPackageServiceImpl implements CarsPackageService {

	// need to inject cars dao
	@Autowired
	private CarsPackageDao carsPackageDao;

	@Override
	@Transactional
	public void regCarsPackage(CarsPackage cp) {
		// TODO Auto-generated method stub
		carsPackageDao.regCarsPackage(cp);

	}

	@Override
	@Transactional
	public List<CarsPackage> getAllCarsPackage() {
		// TODO Auto-generated method stub
		return carsPackageDao.getAllCarsPackage();
	}

	@Override
	@Transactional
	public int upateCarsPackage(CarsPackage cp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCarsPackage(long cp) {
		// TODO Auto-generated method stub
		carsPackageDao.deleteCarsPackage(cp);
		return 0;
	}

	@Override
	public CarsPackage getCarsPackageById(int id) {
		// TODO Auto-generated method stub
		return carsPackageDao.getCarsPackageById(id);

	}

	@Override
	public List<CarsPackage> getCarspackageByCar_Name(String car_name) {
		// TODO Auto-generated method stub
		return carsPackageDao.getCarspackageByCar_Name(car_name);

	}

	@Override
	public List<CarsPackage> getCarsPackageByCar_type(String car_type) {
		// TODO Auto-generated method stub
		return carsPackageDao.getCarsPackageByCar_type(car_type);
	}

	@Override
	public List<CarsPackage> getCarsPackageByDaily() {
		// TODO Auto-generated method stub
		return carsPackageDao.getCarsPackageByDaily();
	}

	@Override
	public List<CarsPackage> getCarsPackageByWeekly() {
		// TODO Auto-generated method stub
		return carsPackageDao.getCarsPackageByWeekly();
	}

	@Override
	public List<CarsPackage> getCarsPackageByMonthly() {
		// TODO Auto-generated method stub
		return carsPackageDao.getCarsPackageByMonthly();
	}

}
