package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.dao.TokenDao;
import com.spring.lms.dao.UserDao;
import com.spring.lms.entity.User;
import com.spring.lms.entity.UserVerfToken;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    TokenDao tokenDao;

    
    @Override
    public User createUser(long sjsuid, String useremail, String password) {
        User user = new User();

        user.setSjsuid(sjsuid);
        user.setUseremail(useremail);
        user.setPassword(password);
        String role = (useremail.endsWith("@sjsu.edu")) ? "ROLE_LIBRARIAN" : "ROLE_PATRON";
        user.setRole(role);

        // TODO Auto-generated method stub
        return userDao.createUser(user);
    }

   
    @Override
    public List<User> listUsers() {
        return userDao.findAll();
    }

    
    @Override
    public User findUser(Integer id) {
        return userDao.getUser(id);
    }

    
    @Override
    public void createToken(User user, String token) {
        UserVerfToken userVerfToken = new UserVerfToken(token, user);
        tokenDao.storeToken(userVerfToken);
    }

   
    @Override
    public UserVerfToken getUserToken(String token) {
        return tokenDao.findToken(token);
    }

    
    @Override
    public void saveValidatedUser(User user) {
        userDao.updateUser(user);
    }

   
    @Override
    public User findUserByEmail(String usermail) {
        User user = userDao.findUserByEmail(usermail);
        return user;
    }
}
