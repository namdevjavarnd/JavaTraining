package com.spring.boot.ems.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.ems.model.User;
import com.spring.boot.ems.model.UserRole;
@Service
public class UserDaoImpl implements UserDao{
	@Autowired
	private UserDao userDao;
	 @Autowired
		private SessionFactory sessionFactory;
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
		userDao.save(user);
		
	}

	
	@Override
	@Transactional
	public void upate(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	@Transactional
	public int deleteUser(long id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from User where id=:id");
		theQuery.setParameter("id", id);

		return  theQuery.executeUpdate();
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	
}
