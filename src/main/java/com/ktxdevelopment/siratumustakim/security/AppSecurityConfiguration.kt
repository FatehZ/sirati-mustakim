package com.ktxdevelopment.siratumustakim.security

import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.stereotype.Component

@EnableWebSecurity
@Component
class AppSecurityConfiguration {

    @ConditionalOnDefaultWebSecurity
    inner class SecurityFilterChainConfiguration{

    }
}