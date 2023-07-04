package com.ktxdevelopment.siratumustakim.auth.security.config;


import com.ktxdevelopment.siratumustakim.auth.security.config.authentication.ApiKeyAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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
    private final ApiKeyAuthenticationFilter apiKeyAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(apiKeyAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/api/v1/auth/register").permitAll()

                .requestMatchers( "/api/v1/posts/**").permitAll()
                .requestMatchers(GET, "/api/v1/posts/**").permitAll()
                .requestMatchers(POST, "/api/v1/posts/**").permitAll()
                .requestMatchers(PUT, "/api/v1/posts/**").permitAll()
                .requestMatchers(DELETE, "/api/v1/posts/**").permitAll()

                .requestMatchers( "/api/v1/categories/**").permitAll()
                .requestMatchers(GET, "/api/v1/categories/**").permitAll()
                .requestMatchers(POST, "/api/v1/categories/**").hasRole(MANAGER.name())
                .requestMatchers(PUT, "/api/v1/categories/**").hasRole(MANAGER.name())
                .requestMatchers(DELETE, "/api/v1/categories/**").hasRole(MANAGER.name())

                .requestMatchers( "/api/v1/tags/**").permitAll()
                .requestMatchers(GET, "/api/v1/tags/**").permitAll()
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
