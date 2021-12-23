package com.spring.lms.time;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Calendar;

@Component("ClockService")
public interface ClockService {

  
    Calendar getCalendar();

    void setCalendar(String dateStr) throws ParseException;

   
    void resetCalendar();

   
    void displayCurrentTime();
}
