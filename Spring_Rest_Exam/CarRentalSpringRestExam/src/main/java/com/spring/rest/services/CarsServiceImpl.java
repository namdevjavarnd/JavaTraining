package com.spring.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.dao.CarsDao;
import com.spring.rest.entity.Cars;
@Service
public class CarsServiceImpl implements CarsService {
   @Autowired
   private CarsDao carsDao;
   
	@Override
	@Transactional
	public void regCars(Cars cars) {
		// TODO Auto-generated method stub
		carsDao.regCars(cars);

	}

	@Override
	@Transactional
	public void upateCars(Cars cars) {
		// TODO Auto-generated method stub
		carsDao.upateCars(cars);
		
		
	}

	@Override
	@Transactional
	public List<Cars> getAllCars() {
		// TODO Auto-generated method stub
		return carsDao.getAllCars();
	}
	

	@Override
	public int getCarById(int id) {
		// TODO Auto-generated method stub
		return  carsDao.getCarById(id);
		
	}

	@Override
	@Transactional
	public List<Cars> getCarByCar_Name(String car_name) {
		// TODO Auto-generated method stub
		return carsDao.getCarByCar_Name(car_name);
	}
	@Override
	@Transactional
	public List<Cars> getCarByCar_type(String car_type) {
		// TODO Auto-generated method stub
		return carsDao.getCarByCar_type(car_type);
	}

	@Override
	public int deleteCars(long id) {
		// TODO Auto-generated method stub
		return carsDao.deleteCars(id);
	}

	


	

}
