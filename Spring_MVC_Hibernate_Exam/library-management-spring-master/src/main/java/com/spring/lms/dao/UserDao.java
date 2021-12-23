/**
 *
 */
package com.spring.lms.dao;

import org.springframework.transaction.annotation.Transactional;

import com.spring.lms.entity.User;

import java.util.List;

@Transactional
public interface UserDao {

   
    User createUser(User uEntity);

   
    List<User> findAll();

  
    User getUser(Integer id);

  
    User findUserByEmail(String usermail);

    void updateUser(User user);

   
    boolean removeUser(Integer id);
}
