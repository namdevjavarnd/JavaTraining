package com.spring.lms.dao;

import com.spring.lms.entity.UserVerfToken;


public interface TokenDao {

   
    UserVerfToken findToken(String token);

    void storeToken(UserVerfToken userVerfToken);
}
