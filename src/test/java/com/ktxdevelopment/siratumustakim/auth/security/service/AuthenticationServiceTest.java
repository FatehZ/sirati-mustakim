package com.ktxdevelopment.siratumustakim.auth.security.service;


import com.ktxdevelopment.siratumustakim.auth.security.model.AuthenticationRequest;
import com.ktxdevelopment.siratumustakim.auth.security.model.AuthenticationResponse;
import com.ktxdevelopment.siratumustakim.auth.security.model.RegisterRequest;
import com.ktxdevelopment.siratumustakim.auth.token.repo.TokenRepository;
import com.ktxdevelopment.siratumustakim.auth.user.model.Role;
import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;
import com.ktxdevelopment.siratumustakim.exceptions.UserNotFoundException;
import com.ktxdevelopment.siratumustakim.auth.user.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenRepository tokenRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        // Prepare test data
        RegisterRequest registerRequest = new RegisterRequest("testuser", "testuser@example.com", "testpassword");

        User savedUser = User.builder()
                .userId("efeij3434834")
                .username("testuser")
                .email("testuser@example.com")
                .encryptedPassword("encryptedPassword")
                .role(Role.USER)
                .build();

        String jwtToken = "jwtToken";
        String refreshToken = "refreshToken";

        // Mock dependencies
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(jwtService.generateToken(any(User.class))).thenReturn(jwtToken);
        when(jwtService.generateRefreshToken(any(User.class))).thenReturn(refreshToken);

        // Perform the registration
        AuthenticationResponse authenticationResponse = authenticationService.register(registerRequest);

        // Verify the results
        assertNotNull(authenticationResponse);
        assertEquals(jwtToken, authenticationResponse.getAccessToken());
        assertEquals(refreshToken, authenticationResponse.getRefreshToken());
        verify(userRepository, times(1)).save(any(User.class));
        verify(jwtService, times(1)).generateToken(any(User.class));
        verify(jwtService, times(1)).generateRefreshToken(any(User.class));
    }

    @Test
    public void testAuthenticate() {
        // Prepare test data
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail("testuser@example.com");
        authenticationRequest.setPassword("testpassword");

        User user = User.builder()
                .userId("efeij3434834")
                .username("testuser")
                .email("testuser@example.com")
                .encryptedPassword("encryptedPassword")
                .role(Role.USER)
                .build();

        String jwtToken = "jwtToken";
        String refreshToken = "refreshToken";

        // Mock dependencies
        when(userRepository.findByEmail("testuser@example.com")).thenReturn(Optional.of(user));
        when(jwtService.generateToken(any(User.class))).thenReturn(jwtToken);
        when(jwtService.generateRefreshToken(any(User.class))).thenReturn(refreshToken);

        // Perform authentication
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);

        // Verify the results
        assertNotNull(authenticationResponse);
        assertEquals(jwtToken, authenticationResponse.getAccessToken());
        assertEquals(refreshToken, authenticationResponse.getRefreshToken());

        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userRepository, times(1)).findByEmail("testuser@example.com");
        verify(jwtService, times(1)).generateToken(any(User.class));
        verify(jwtService, times(1)).generateRefreshToken(any(User.class));
        verify(tokenRepository, times(1)).findAllValidTokenByUser(any(String.class));
//        verify(tokenRepository, times(1)).saveAll(anyIterable());
    }

    @Test
    public void testAuthenticate_UserNotFound() {
        // Prepare test data
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail("testuser@example.com");
        authenticationRequest.setPassword("testpassword");

        // Mock dependencies
        when(userRepository.findByEmail("testuser@example.com")).thenReturn(Optional.empty());

        // Perform authentication and verify the UserNotFoundException
        assertThrows(UserNotFoundException.class, () -> authenticationService.authenticate(authenticationRequest));

        // Verify that the userRepository.findByEmail method was called
        verify(userRepository, times(1)).findByEmail("testuser@example.com");
    }

    // Add more test methods for other scenarios as needed

}