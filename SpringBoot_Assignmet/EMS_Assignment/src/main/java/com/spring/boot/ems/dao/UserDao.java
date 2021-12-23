package com.spring.boot.ems.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.spring.boot.ems.model.User;
import com.spring.boot.ems.model.UserRole;


@Repository
public interface UserDao {
	
	    User findByEmail(String email);
	    User findByName(String name);
	    User findByActivationToken(String activationToken);
	    User findByResetToken(String resetToken);
	    User findById(long id);
	    List<User> findAll();
		void save(User user);
		void update(User user);
	
		int deleteUser(long id);
		void upate(User user);
	
		

}
