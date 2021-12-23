package com.spring.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dao.ClassDao;
import com.spring.boot.model.ClassInfo;
import com.spring.boot.service.ClassInfoService;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.spring.boot.Controller")
@RequestMapping("/api/v1")
public class ClassInfoController {

	@Autowired
	private ClassInfoService classInfoService;

	

	// handler method to handle list students and return mode and view

	@GetMapping("/classInfo")
	public ResponseEntity<List<ClassInfo>> getAllClassInfo() {
		List<ClassInfo> list = classInfoService.getAllClassInfo();
		return new ResponseEntity<List<ClassInfo>>(list, HttpStatus.OK);
	}

	@GetMapping("/class/{id}")
	public ResponseEntity<ClassInfo> getClassById(@PathVariable("id") Integer id) {
		ClassInfo std = classInfoService.deleteClassById(id);
		return new ResponseEntity<ClassInfo>(std, HttpStatus.OK);
	}


	@PostMapping("/classSave")
	public ResponseEntity<String> saveClass(@RequestBody ClassInfo classInfo) {
		ClassInfo id = classInfoService.saveClass(classInfo);
		return new ResponseEntity<String>("Class with '" + id + "' has been saved", HttpStatus.OK);
	}

	@PutMapping("/Update/{id}")
	public ResponseEntity<String> updateClass(@PathVariable("id") Integer id, @RequestBody ClassInfo classInfo) {
		ClassInfo cls = classInfoService.getClassById(id);
		cls.setName(classInfo.getName());

		ClassInfo id1 = classInfoService.saveClass(cls);
		return new ResponseEntity<String>("Class with '" + id1 + "' has been updated", HttpStatus.OK);

	}

	@DeleteMapping("deleteClass/{id}")
	public ResponseEntity<String> deleteClassById(@PathVariable("id") Integer id) {
		classInfoService.deleteClassById(id);
		return new ResponseEntity<String>("Class with '" + id + "' has been deleted", HttpStatus.OK);
	}

//	@GetMapping("/class/edit/{id}")
//	public String editClassForm(@PathVariable Long id, Model model) {
//		model.addAttribute("class", classInfoService.getClassById(id));
//		return "edit_class";
//
//	}

//	@PostMapping("/class/{id}")
//	public String updateClass(@PathVariable Long id, @ModelAttribute("class") ClassInfo classinfo, Model model) {
//
//		// get student from database by id
//		ClassInfo existingClass = classInfoService.getClassById(id);
//		existingClass.setId(id);
//		existingClass.setName(classinfo.getName());
//
//		// save updated student object
//		classInfoService.updateClass(existingClass);
//		return "redirect:/students";
//	}

	// handler method to handle delete student request
	
//	@GetMapping("/ClassInfo/new")
//	public String createClassForm(Model model) {
//
//		// create student object to hold student form data
//		ClassInfo classinfo = new ClassInfo();
//		model.addAttribute("student", classinfo);
//		return "create_class";
//
//	}

}
