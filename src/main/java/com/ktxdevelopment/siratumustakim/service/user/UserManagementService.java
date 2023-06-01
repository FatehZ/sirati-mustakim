package com.ktxdevelopment.siratumustakim.service.user;


import com.ktxdevelopment.siratumustakim.model.entities.role.Role;
import com.ktxdevelopment.siratumustakim.model.entities.user.User;

import java.util.List;

interface UserManagementService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
