package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.dao.UserBookDao;

@Service
public class UserBookServiceImpl implements UserBookService {

    @Autowired
    UserBookDao userBookDao;
    
    @Override
    public int getUserDayBookCount(int userId) {
        return userBookDao.getUserDayBookCount(userId);
    }

    
    @Override
    public boolean checkIfEsxists(Integer bookid) {
        return userBookDao.exists(bookid);
    }


}
