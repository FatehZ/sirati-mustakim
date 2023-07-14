package com.ktxdevelopment.siratumustakim.admin.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    void upgradeUserToManager(String userId);

}
