package com.spring.lms.registration.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.lms.email.SendEmail;
import com.spring.lms.entity.User;
import com.spring.lms.registration.RegistrationCompleteEvent;
import com.spring.lms.service.UserService;

import java.util.UUID;


@Component
@Service
public class RegistrationListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserService userService;

    @Autowired
    private SendEmail sendEmail;

   
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent registrationCompleteEvent) {
        this.confirmRegistration(registrationCompleteEvent);
    }

   
    private void confirmRegistration(RegistrationCompleteEvent registrationCompleteEvent) {
        User user = registrationCompleteEvent.getUser();
        String token = UUID.randomUUID().toString();

        userService.createToken(user, token);

        String toAddress = user.getUseremail();
        String emailSubject = "Please validate your Account";
        String clickURL = registrationCompleteEvent.getUrl() + "/confirmRegistration.html?token=" + token;
        String emailMessage = "Registration successful. Next Step \r\n" + clickURL;
        System.out.println(" The following email will be sent: " + emailMessage);
        sendEmail.sendMail(toAddress, emailSubject, emailMessage);
    }
}
