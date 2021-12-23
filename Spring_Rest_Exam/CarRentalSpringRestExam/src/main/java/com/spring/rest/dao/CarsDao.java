package com.spring.rest.dao;

import java.util.List;

import com.spring.rest.entity.Cars;



public interface CarsDao {
	
	public void regCars(Cars cars);

	public void upateCars(Cars cars);

	public int deleteCars(long id);

	public int getCarById(int id);

	public List<Cars> getCarByCar_type(String car_type);

	public List<Cars> getAllCars();

	List<Cars> getCarByCar_Name(String car_name);

	int deleteCars(Cars cars);

}


