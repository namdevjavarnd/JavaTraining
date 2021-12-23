package com.spring.boot.ems.service;

import java.util.List;
import java.util.Set;

import com.spring.boot.ems.model.User;
import com.spring.boot.ems.model.UserRole;




public interface UserService {
	
	 User findByEmail(String email);

	    User findByName(String name);

	    User findByActivationToken(String activationToken);

	    User findByResetToken(String resetToken);

	    User findById(long id);

	    List<User> findAll();


	   

		void save(User user);

		void upate(User user);

	int deleteUser(long l);
}
