package com.spring.boot.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.ems.dao.EnquiryDao;
import com.spring.boot.ems.dao.UserDao;
import com.spring.boot.ems.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	@Transactional
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	@Transactional
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	@Override
	@Transactional
	public User findByActivationToken(String activationToken) {
		// TODO Auto-generated method stub
		 return userDao.findByActivationToken(activationToken);
	}

	@Override
	@Transactional
	public User findByResetToken(String resetToken) {
		// TODO Auto-generated method stub
		 return userDao.findByResetToken(resetToken);
	}

	@Override
	@Transactional
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	@Transactional
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		 userDao.save(user);

	}

	@Override
	@Transactional
	public void upate(User user) {
		// TODO Auto-generated method stub
		 userDao.upate(user);
	}

	@Override
	@Transactional
	public int deleteUser(long id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

}
