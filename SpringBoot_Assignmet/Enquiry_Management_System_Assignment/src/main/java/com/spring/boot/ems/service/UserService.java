

package com.spring.boot.ems.service;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.boot.ems.model.Role;
import com.spring.boot.ems.model.User;
import com.spring.boot.ems.model.UserRole;
import com.spring.boot.ems.repository.UserRepository;
import com.spring.boot.ems.repository.UserRoleRepository;

/*
 * Customer Service registered users (staff)
 */

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    private UserRoleRepository roleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByUsername(String username) {
        User user = userRepository.findByEmail(username);
        return user;
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getAllSinCurrent(User user) {
        List<User> users = userRepository.findAll();
        users.remove(user);
        return users;
    }

    public User findByActivationToken(String activationToken) {
        return userRepository.findByActivationToken(activationToken);
    }

    public User findByResetToken(String activationToken) {
        return userRepository.findByResetToken(activationToken);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    /*
     * Takes users loaded in DB from data.sql and saves them back to DB
     * encoding passwords and ensuring that they are activated and with
     * the right priviledges.
     */
    public void addDbUser(Role role) {
        UserRole dbRole = roleRepository.findByRole(role.getText());
        Set<UserRole> dbRoles = new HashSet<>();
        dbRoles.add(dbRole);
        List<User> users = userRepository.findByRoles(dbRoles);
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        if (users != null) {
            for (User user : users) {
                user.setRegistered(currentZonedDateTime);
                user.getRoles().add(dbRole);
                String password = user.getPassword();
                user.setPassword(passwordEncoder.encode(password));
                user.setEnabled(true);
                userRepository.save(user);
                logger.debug(user.getEmail() + ",roles: " +
                        user.getRoles().toString() + " - user pasword encrypted");
            }
        }
    }

    public void addWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(Role.DEFAULT.getText());
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }

    public void addWithAdminRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(Role.ADMIN.getText());
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }

    public boolean isNameAvailable(User user) {
        if (userRepository.findByName(user.getName()) == null) return true;
        return false;
    }

    public boolean isEmailAvailable(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null) return true;
        return false;
    }

    /*
     * To display user's list in search options as drop-down list
     */
    public List<String> getUserListAsStringList() {
        List<String> userList = getAll().stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());
        userList.add("any user");
        return userList;
    }

    public void trimUserEmail(User user) {
        User userEmailTrimmed = userRepository.findById(user.getId());
        userEmailTrimmed.setEmail(userEmailTrimmed.getEmail().trim());
        userRepository.save(userEmailTrimmed);
    }


}








