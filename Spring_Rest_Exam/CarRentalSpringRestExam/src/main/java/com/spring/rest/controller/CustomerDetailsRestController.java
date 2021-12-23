package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.CarsPackage;
import com.spring.rest.entity.CustomersDetail;
import com.spring.rest.services.CarsPackageService;
import com.spring.rest.services.CustomerDetailsService;

@RestController
@RequestMapping("/api/v1")
public class CustomerDetailsRestController {
	@Autowired
	private CustomerDetailsService customerDatailsService;

	private List<CustomersDetail> customerDetails;

	@GetMapping("/customer")
	public String sayHello() {
		return "Hello  World!";
	}

	@GetMapping("/customers")
	public List<CustomersDetail> getAllCustomers() {
		return customerDetails;
	}

	@PostMapping("/customer")
	public void regCustomer(CustomersDetail cx) {

		customerDatailsService.regCustomer(cx);
	}

	@PostMapping("/customer")
	public void upateCustomer(CustomersDetail cx) {
		customerDatailsService.regCustomer(cx);
	}
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCars(@PathVariable String cp) {
		{
			try {
				this.customerDatailsService.deleteCustomer(Long.parseLong(cp));
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@GetMapping("/customer/{customerId}")
	public CustomersDetail getCustomerById(int id) {
		CustomersDetail customerDeatls = customerDatailsService.getCustomerById(id);
		return customerDatailsService.getCustomerById(id);

		
	}
	@GetMapping("/customer/{customerName}")
	public List<CustomersDetail> getCarspackageByCustomer_Name() {
		return null;
	}
	@GetMapping("/customer/{customerContact}")
	public List<CustomersDetail> getCustomerByCustomer_Contact() {
		return null;
	}
	@GetMapping("/customer/{customerAddress}")
	public List<CarsPackage> getCustomerByCustomer_Address() {
		return null;
	}

}
