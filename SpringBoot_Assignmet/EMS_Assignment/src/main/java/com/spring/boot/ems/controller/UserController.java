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
import com.spring.boot.ems.model.User;
import com.spring.boot.ems.service.EnquiryService;
import com.spring.boot.ems.service.UserService;

@Controller
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public String sayHello() {
		return "Hello Class World!";
	}
	@GetMapping("/userByEmail/{email}")
	 User findByEmail(@PathVariable String email) {
		List<User> eq = (List<User>) userService.findByEmail(email);
		return userService.findByEmail(email);
	}
	
	@PostMapping("/user_save")
	public void save(@RequestBody User user) {
		userService.save(user);
	
	}
	
	@PutMapping("/user_update")
	public void upate(@RequestBody User user) {
		userService.upate(user);

	}
	@GetMapping("/userByName/{name}")
	    User findByName(@PathVariable String name) {
		List<User> eq = (List<User>) userService.findByName(name);
		return userService.findByName(name);
				
		}
	@GetMapping("/user/{activationToken}")
	    User findByActivationToken(@PathVariable String activationToken) {
		User user = userService.findByActivationToken(activationToken);
		return userService.findByActivationToken(activationToken);
		}
	
	@GetMapping("/user{id}")
	    User findById(@PathVariable long id) {
		User eq = userService.findById(id);
		return userService.findById(id);
		}
	@GetMapping("/users")
	    List<User> findAll() {
		return userService.findAll();
		}
	@DeleteMapping("/user/{user_Id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
		{
			try {
				this.userService.deleteUser(Long.parseLong(id));
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
	}

	   

	
}
