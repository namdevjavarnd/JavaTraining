/**
 *
 */
package com.spring.lms.service;

import java.util.List;

import com.spring.lms.entity.User;
import com.spring.lms.entity.UserVerfToken;


public interface UserService {


    User createUser(long sjsuid, String useremail, String password);

  
    List<User> listUsers();

   
    public User findUser(Integer id);

    
    public User findUserByEmail(String usermail);

   
    void createToken(User user, String token);

    
    UserVerfToken getUserToken(String token);

    
    void saveValidatedUser(User user);
}
