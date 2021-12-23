

package com.spring.boot.ems.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.boot.ems.model.Role;
import com.spring.boot.ems.model.User;
import com.spring.boot.ems.model.UserRole;
import com.spring.boot.ems.repository.UserRepository;
import com.spring.boot.ems.repository.UserRoleRepository;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;


    public UserRole getUserRole(String role) {
        return userRoleRepository.findByRole(role);
    }


}