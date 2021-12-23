package com.spring.rest.services;

import java.util.List;

import com.spring.rest.dao.CarsDao;
import com.spring.rest.entity.Cars;

public interface CarsService {

	
	public void regCars(Cars cars);

	public void upateCars(Cars cars);

	public int deleteCars(long id);

	public int getCarById(int id);

	public List<Cars> getCarByCar_Name(String car_name);

	public List<Cars> getCarByCar_type(String car_type);

	public List<Cars> getAllCars();

	
	
}
