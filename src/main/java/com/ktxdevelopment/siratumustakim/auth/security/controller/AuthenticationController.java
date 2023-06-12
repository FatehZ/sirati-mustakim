package com.ktxdevelopment.siratumustakim.auth.security.controller;

import com.ktxdevelopment.siratumustakim.auth.security.model.AuthenticationRequest;
import com.ktxdevelopment.siratumustakim.auth.security.model.AuthenticationResponse;
import com.ktxdevelopment.siratumustakim.auth.security.model.RegisterRequest;
import com.ktxdevelopment.siratumustakim.auth.security.service.AuthenticationService;
import com.ktxdevelopment.siratumustakim.util.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.RestResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<CustomResponseModel<AuthenticationResponse>> register(@RequestBody RegisterRequest request) {
    return RestResponse.ok(service.register(request));
  }


  @PostMapping("/authenticate")
  public ResponseEntity<CustomResponseModel<AuthenticationResponse>> authenticate(@RequestBody AuthenticationRequest request) {
    return RestResponse.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public ResponseEntity<CustomResponseModel<AuthenticationResponse>> refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
    return RestResponse.ok(service.refreshToken(request, response));
  }
}
