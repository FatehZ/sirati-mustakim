package com.ktxdevelopment.siratumustakim.auth.security.model;

import com.ktxdevelopment.siratumustakim.auth.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String username;
  private String email;
  private String password;
  private Role role;
}