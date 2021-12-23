

package com.spring.boot.ems;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.boot.ems.model.Role;
import com.spring.boot.ems.service.EnquiryService;
import com.spring.boot.ems.service.UserService;
import com.spring.boot.ems.util.EnquiryListWrapper;

import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.concurrent.TimeUnit;

@Profile("!test")
@Configuration
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class}) // disabled in application.properties
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    UserService userService;

    @Autowired
    EnquiryService enquiryService;

    /*
     * Adds users with roles pre-defined in data.sql
     * when the application is starting
     */
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        userService.addDbUser(Role.APPADMIN);
        userService.addDbUser(Role.ADMIN);
        userService.addDbUser(Role.DEFAULT);

        /*
         * Adds progress users to display in sample enquiries
         */
        enquiryService.addProgressUser(13L, 1L);
        enquiryService.addProgressUser(14L, 1L);

        userService.getAll().forEach(u -> userService.trimUserEmail(u));
    }


    @Bean
    public EnquiryListWrapper createEnquiryListWrapper() {
        return new EnquiryListWrapper();
    }


}
		
		

