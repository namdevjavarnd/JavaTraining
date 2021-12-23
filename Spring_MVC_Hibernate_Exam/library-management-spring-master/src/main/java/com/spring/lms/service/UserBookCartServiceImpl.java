package com.spring.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.lms.dao.UserBookCartDao;
import com.spring.lms.entity.Book;
import com.spring.lms.entity.UserBookCart;
import com.spring.lms.errors.Err;

import java.util.List;

@Service
public class UserBookCartServiceImpl implements UserBookCartService {

    @Autowired
    UserBookCartDao userBookCartDao;

    
    @Override
    public Err addUserBookToCart(UserBookCart ubc) {
        if (ubc.getType_return() > 0) {
            return userBookCartDao.addUserBookToCartReturn(ubc);
        } else {
            return userBookCartDao.addUserBookToCartIssue(ubc);
        }
    }

  
    @Override
    public List<UserBookCart> getUserCart(int userid, boolean isTypeReturn) {
        if (isTypeReturn) {
            return userBookCartDao.getUserCartReturn(userid);
        } else {
            return userBookCartDao.getUserCartIssue(userid);
        }

    }

   
    @Override
    public void clearUserCart(int userid, boolean isTypeReturn) {
        List<UserBookCart> userBookCartList;
        if (isTypeReturn) {
            userBookCartList = userBookCartDao.getUserCartReturn(userid);
        } else {
            userBookCartList = userBookCartDao.getUserCartIssue(userid);
        }
        for (UserBookCart u : userBookCartList) {
            userBookCartDao.removeCartEntry(u);
        }
    }

  
    @Override
    public List<Book> getUserBooks(int userId, boolean isTypeReturn) {
        List<Book> books;
        if (isTypeReturn) {
            books = userBookCartDao.getUserBooksInCartReturn(userId);
        } else {
            books = userBookCartDao.getUserBooksInCartIssue(userId);
        }
        return books;
    }
}
