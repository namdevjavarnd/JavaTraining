package com.spring.boot.ems;

import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

public class CustomSecurityMockMvcRequestPostProcessors {

    public static RequestPostProcessor demo() {
        return user("demo@demo.com").password("111111").roles("USER");
    }

    public static RequestPostProcessor latiDude() {
        return user("namdev@gmail.com").password("0011100").roles("APPADMIN");
    }

    public static RequestPostProcessor latiTest() {
        return user("namdevtest@gmail.com").password("1100011").roles("ADMIN");
    }


}
