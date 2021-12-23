

package com.spring.boot.ems.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.ems.model.User;
import com.spring.boot.ems.model.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByName(String name);

    User findByActivationToken(String activationToken);

    User findByResetToken(String resetToken);

    User findById(long id);

    List<User> findAll();


    List<User> findByRoles(Set<UserRole> role);

}
