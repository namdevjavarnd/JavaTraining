package com.spring.lms.registration;

import org.springframework.context.ApplicationEvent;

import com.spring.lms.entity.User;



public class RegistrationCompleteEvent extends ApplicationEvent {
    private final String url;
    private final User user;

  
    public RegistrationCompleteEvent(User user, String url) {
        super(user);
        this.url = url;
        this.user = user;
    }

    
    public String getUrl() {
        return url;
    }

  
    public User getUser() {
        return user;
    }
}
