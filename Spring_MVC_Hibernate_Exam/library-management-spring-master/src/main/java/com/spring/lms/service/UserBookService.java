package com.spring.lms.service;

public interface UserBookService {

   
    int getUserDayBookCount (int userId);

   
    boolean checkIfEsxists(Integer bookid);

}
