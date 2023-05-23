package com.ktxdevelopment.siratumustakim.service.user;


import java.util.List;

interface UserManagementService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
