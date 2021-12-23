package com.spring.lms.service;

import java.util.List;

import com.spring.lms.entity.Book;
import com.spring.lms.entity.UserBookCart;
import com.spring.lms.errors.Err;

public interface UserBookCartService {

   
    public Err addUserBookToCart(UserBookCart ubc);

    public List<UserBookCart> getUserCart(int userid, boolean isTypeReturn);

    void clearUserCart(int userid, boolean isTypeReturn);

    List<Book> getUserBooks(int userId, boolean isTypeReturn);
}
