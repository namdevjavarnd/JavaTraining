package com.spring.boot.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.ems.model.Enquiry;

import com.spring.boot.ems.service.EnquiryService;

@Controller
@RequestMapping("/api/v1")
public class EnquiryController {
	@Autowired
	private EnquiryService enquiryService;
	 
	private List<Enquiry> eq;
	
	@GetMapping("/enquiry")
	public String sayHello() {
		return "Hello Class World!";
	}
	@GetMapping("/enquiries")
	public List<Enquiry> getAllEnquiry() {
		return enquiryService.getAllEnquiry();
	}
	
	@PutMapping("/enquiry_update")
	public void upate(@RequestBody Enquiry eq) {
		enquiryService.upate(eq);

	}
	@PostMapping("/enquiry_save")
	public void save(@RequestBody Enquiry eq) {
		enquiryService.save(eq);
	
	}
	@GetMapping("/enquiry/{enquiry_Id}")
	public int getEnquiryById(@PathVariable int id) {
		int eq = enquiryService.getEnquiryById(id);
		//return carService.getCarById(id);
		
		//if ((id >= cars.size()) || (id < 0)) {
		//throw new CarNotFoundException("Car Id not found -" + id);
		//}
		return enquiryService.getEnquiryById(id);
	}
	@GetMapping("/enquiries/{name}")
	public List<Enquiry> getEnquiryByName(@PathVariable String name) {
		List<Enquiry> eq = enquiryService.getEnquiryByName(name);
		return enquiryService.getEnquiryByName(name);
	}
	@DeleteMapping("/enquiries/{enquiry_Id}")
	public ResponseEntity<HttpStatus> deleteEnquiry(@PathVariable String id) {
		{
			try {
				this.enquiryService.deleteEnquiry(Long.parseLong(id));
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}

}
