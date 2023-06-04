package com.ktxdevelopment.siratumustakim.user.service;


import com.ktxdevelopment.siratumustakim.role.entity.Role;
import com.ktxdevelopment.siratumustakim.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
