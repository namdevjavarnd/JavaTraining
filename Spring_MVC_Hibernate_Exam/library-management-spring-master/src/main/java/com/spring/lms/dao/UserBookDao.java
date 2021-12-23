package com.spring.lms.dao;

import org.springframework.transaction.annotation.Transactional;

import com.spring.lms.entity.UserBook;


@Transactional
public interface UserBookDao {
   
    int getUserDayBookCount(int userId);

    boolean exists(Integer bookid);

   
    boolean removeUserBook(UserBook userBook);
}
