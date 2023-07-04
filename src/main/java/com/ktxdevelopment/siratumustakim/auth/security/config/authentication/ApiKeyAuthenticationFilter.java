package com.ktxdevelopment.siratumustakim.auth.security.config.authentication;

import com.ktxdevelopment.siratumustakim.exceptions.ApiKeyInvalidException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Slf4j
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

    private static final String API_KEY_HEADER = "X-API-Key";
    private final String apiKey;

    public ApiKeyAuthenticationFilter(@Value("${application.security.api-key}") String apiKey) {
        this.apiKey = apiKey;
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) {

        String providedApiKey = request.getHeader(API_KEY_HEADER);

        if (providedApiKey != null && providedApiKey.equals(apiKey)) {
            log.error("Filter 3");
            filterChain.doFilter(request, response);
        }
        else {
            throw new ApiKeyInvalidException();
        }
    }
}