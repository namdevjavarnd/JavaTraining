package com.spring.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
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


import com.spring.boot.model.ClassInfo;
import com.spring.boot.model.Department;
import com.spring.boot.service.ClassInfoService;
import com.spring.boot.service.DepartmentService;
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.spring.boot.Controller")
public class DepartmentController {

	
	@Autowired
	private DepartmentService deptService;
	


	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartment() {
		List<Department> list = deptService.getAllDepartment();
		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
	}

	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id) {
		Department dept = deptService.getDepartmentById(id);
		return new ResponseEntity<Department>(dept, HttpStatus.OK);
	}


	@PostMapping("/deptsave")
	public ResponseEntity<String> saveDepartment(@RequestBody Department dept) {
		Department dept1 = deptService.saveDepartment(dept);
		return new ResponseEntity<String>("Class with '" + dept1 + "' has been saved", HttpStatus.OK);
	}

	@PutMapping("/updateDept/{id}")
	public ResponseEntity<String> updateDepartment(@PathVariable("id") Integer id, @RequestBody Department dept) {
		Department dept1 = deptService.getDepartmentById(id);
		 dept1.setName(dept1.getName());
		 dept1.setHod(dept1.getHod());
		 dept1.setLocation(dept1.getLocation());
	        Department id1 = deptService.saveDepartment(dept1);
	        return new ResponseEntity<String>("Department with '"+id1+"' has been updated",HttpStatus.OK);

	}

	@DeleteMapping("deleteDept/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
		deptService.deleteById(id);
		return new ResponseEntity<String>("Department with '" + id + "' has been deleted", HttpStatus.OK);
	}
}
