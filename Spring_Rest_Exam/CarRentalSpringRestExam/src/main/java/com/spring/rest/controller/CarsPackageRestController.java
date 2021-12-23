package com.spring.rest.controller;

import java.util.List;

import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Cars;
import com.spring.rest.entity.CarsPackage;
import com.spring.rest.services.CarsPackageService;
import com.spring.rest.services.CarsService;

@RestController
@RequestMapping("/api/v1")
public class CarsPackageRestController {
	@Autowired
	private CarsPackageService carsPackageService;
	
	private List<CarsPackage> carsPackage;
	
	@GetMapping("/carsPackage")
	public List<CarsPackage> getAllCarsPackage(int id) {
		return carsPackageService.getAllCarsPackage();
	}
	@PostMapping("/carsPackage")
	public void regCarsPackage(CarsPackage cp) {
		carsPackageService.regCarsPackage(cp);
	}
	@PutMapping("/carsPackage")
	public void upateCarsPackage(CarsPackage cp) {
		carsPackageService.regCarsPackage(cp);
	}

	@DeleteMapping("/carsPackage/{cp}")
	public ResponseEntity<HttpStatus> deleteCars(@PathVariable String cp) {
	{
		try {
			this.carsPackageService.deleteCarsPackage(Long.parseLong(cp));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}
	@GetMapping("/carsPackage/{carPackageId}")
	public CarsPackage getCarsPackageById(int id) {
		CarsPackage carsPackage = carsPackageService.getCarsPackageById(id);
		return carsPackageService.getCarsPackageById(id);

		
	}
	@GetMapping("/carsPackages/{carPackageName}")
	public List<CarsPackage> getCarspackageByCar_Name(String car_name) {
		List<CarsPackage> carsPackage = carsPackageService.getCarspackageByCar_Name(car_name);
		return carsPackageService.getCarspackageByCar_Name(car_name);
	}
	
	@GetMapping("/carsPackages/{carPackageType}")
	public List<CarsPackage> getCarsPackageByCar_type(String car_type) {
		return null;
	}
	@GetMapping("/carsPackages/{carPackageDaily}")
	public List<CarsPackage> getCarsPackageByDaily() {
		return null;
	}
	@GetMapping("/carsPackages/{carPackageWeekly}")
	public List<CarsPackage> getCarsPackageByWeekly() {
		return null;
	}
	@GetMapping("/carsPackages/{carPackageMonthly}")
	public List<CarsPackage> getCarsPackageByMonthly() {
		return null;
	}
	@GetMapping("/carsPackages/{carPackageType}")
	public List<CarsPackage> getAllCarsPackage() {
		return null;
	}
	
	
}
