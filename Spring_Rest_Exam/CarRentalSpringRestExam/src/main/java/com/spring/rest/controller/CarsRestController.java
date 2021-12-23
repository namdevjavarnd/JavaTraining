package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Cars;
import com.spring.rest.services.CarsService;

@RestController
@RequestMapping("/api/v1")
public class CarsRestController {
	@Autowired
	private CarsService carService;

	private List<Cars> cars;

	@GetMapping("/car")
	public String sayHello() {
		return "Hello Class World!";
	}

	@GetMapping("/cars")
	public List<Cars> getAllCars() {
		return carService.getAllCars();
	}

	@GetMapping("/cars/{carId}")
	public int getCarById(@PathVariable int id) {
		int cars = carService.getCarById(id);
		//return carService.getCarById(id);
		
		//if ((id >= cars.size()) || (id < 0)) {
		//throw new CarNotFoundException("Car Id not found -" + id);
		//}
		return carService.getCarById(id);
	}

	@GetMapping("/cars/{car_name}")
	public List<Cars> getCarByCar_Name(@PathVariable String car_name) {
		List<Cars> cars = carService.getCarByCar_Name(car_name);
		return carService.getCarByCar_Name(car_name);
	}

	@PutMapping("/cars")
	public void upateCars(@RequestBody Cars cars) {
		carService.upateCars(cars);

	}

	@PostMapping("/cars")
	public void regCars(@RequestBody Cars cars) {
	carService.regCars(cars);
	
	}

	@DeleteMapping("/cars/{carId}")
	public ResponseEntity<HttpStatus> deleteCars(@PathVariable String id) {
		{
			try {
				this.carService.deleteCars(Long.parseLong(id));
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}
}
