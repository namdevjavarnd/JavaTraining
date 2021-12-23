package com.spring.lms.dao;

import org.springframework.transaction.annotation.Transactional;

import com.spring.lms.entity.Book;
import com.spring.lms.entity.UserBookCart;
import com.spring.lms.errors.Err;

import java.util.List;

@Transactional

public interface UserBookCartDao {

  
    Err addUserBookToCartIssue(UserBookCart ubc);

    Err addUserBookToCartReturn(UserBookCart ubc);

   
    List<UserBookCart> getUserCartIssue(int userid);

   
    List<UserBookCart> getUserCartReturn(int userid);

    boolean removeCartEntry(UserBookCart ubc);

    List<Book> getUserBooksInCartIssue(int userId);

   
    List<Book> getUserBooksInCartReturn(int userId);
}