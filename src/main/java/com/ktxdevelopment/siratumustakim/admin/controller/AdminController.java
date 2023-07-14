package com.ktxdevelopment.siratumustakim.admin.controller;


import com.ktxdevelopment.siratumustakim.admin.service.AdminService;
import com.ktxdevelopment.siratumustakim.manager.category.model.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/upgrade/{id}")
    private ResponseEntity<String> giveManagerRoleToUser(@PathVariable String id) {
        adminService.upgradeUserToManager(id);
        return ResponseEntity.ok("Added successfully");
    }

}
