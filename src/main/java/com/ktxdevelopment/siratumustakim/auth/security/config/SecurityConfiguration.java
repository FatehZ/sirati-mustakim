package com.ktxdevelopment.siratumustakim.auth.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.ktxdevelopment.siratumustakim.auth.user.model.Role.*;
import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").hasRole(GUEST.name()) //todo permitAll()
                .requestMatchers( "/api/v1/posts/**").hasRole(GUEST.name())
                .requestMatchers(GET, "/api/v1/posts/**").hasRole(GUEST.name())
                .requestMatchers(POST, "/api/v1/posts/**").hasRole(MANAGER.name())
                .requestMatchers(PUT, "/api/v1/posts/**").hasRole(MANAGER.name())
                .requestMatchers(DELETE, "/api/v1/posts/**").hasRole(MANAGER.name())

                .requestMatchers( "/api/v1/categories/**").hasRole(GUEST.name())
                .requestMatchers(GET, "/api/v1/categories/**").hasRole(GUEST.name())
                .requestMatchers(POST, "/api/v1/categories/**").hasRole(MANAGER.name())
                .requestMatchers(PUT, "/api/v1/categories/**").hasRole(MANAGER.name())
                .requestMatchers(DELETE, "/api/v1/categories/**").hasRole(MANAGER.name())

                .requestMatchers( "/api/v1/tags/**").hasRole(GUEST.name())
                .requestMatchers(GET, "/api/v1/tags/**").hasRole(GUEST.name())
                .requestMatchers(POST, "/api/v1/tags/**").hasRole(MANAGER.name())
                .requestMatchers(PUT, "/api/v1/tags/**").hasRole(MANAGER.name())
                .requestMatchers(DELETE, "/api/v1/tags/**").hasRole(MANAGER.name())

                .requestMatchers( "/api/v1/users/**").hasRole(MANAGER.name())
                .requestMatchers(GET, "/api/v1/users/**").hasRole(MANAGER.name())
                .requestMatchers(POST, "/api/v1/users/**").hasRole(ADMIN.name())
                .requestMatchers(PUT, "/api/v1/users/**").hasRole(ADMIN.name())
                .requestMatchers(DELETE, "/api/v1/users/**").hasRole(ADMIN.name())

                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout().logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
        return http.build();
    }

}
