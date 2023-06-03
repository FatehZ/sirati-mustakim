package com.ktxdevelopment.siratumustakim.service.user;


import com.ktxdevelopment.siratumustakim.model.role.entity.Role;
import com.ktxdevelopment.siratumustakim.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
