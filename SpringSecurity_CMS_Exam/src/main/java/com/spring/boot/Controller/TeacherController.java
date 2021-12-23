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
import com.spring.boot.model.Teacher;
import com.spring.boot.service.ClassInfoService;
import com.spring.boot.service.TeacherService;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.spring.boot.Controller")
@RequestMapping("/api/v1")
public class TeacherController {
	
	
	@Autowired
	private TeacherService teacherService;

	

	// handler method to handle list students and return mode and view

	@GetMapping("/teachers")
	public ResponseEntity<List<Teacher>> getAllTeacher() {
		List<Teacher> list = teacherService.getAllTeacher();
		return new ResponseEntity<List<Teacher>>(list, HttpStatus.OK);
	}

	@GetMapping("/teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Integer id) {
		Teacher std = teacherService.getTeacherById(id);
		return new ResponseEntity<Teacher>(std, HttpStatus.OK);
	}


	@PostMapping("/saveTeacher")
	public ResponseEntity<String> saveTeacher(@RequestBody Teacher teacher) {
		Teacher id = teacherService.saveTeacher(teacher);
		return new ResponseEntity<String>("Teacher with '" + id + "' has been saved", HttpStatus.OK);
	}

	@PutMapping("/updateTeacher/{id}")
	public ResponseEntity<String> updateTeacher(@PathVariable("id") Integer id, @RequestBody Teacher teacher) {
		Teacher teacher1 = teacherService.getTeacherById(id);
		teacher.setName(teacher.getName());

		Teacher id1 = teacherService.saveTeacher(teacher1);
		return new ResponseEntity<String>("Teacher with '" + id1 + "' has been updated", HttpStatus.OK);

	}

	@DeleteMapping("deleteTeacher/{id}")
	public ResponseEntity<String> deleteTeacherById(@PathVariable("id") Integer id) {
		teacherService.deleteTeacherById(id);
		return new ResponseEntity<String>("Teacher with '" + id + "' has been deleted", HttpStatus.OK);
	}


}
