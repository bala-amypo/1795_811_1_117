package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final JwtTokenProvider provider;

    public JwtUtil(JwtTokenProvider provider) {
        this.provider = provider;
    }

    public String generateToken(String username) {
        return provider.generateToken(username);
    }

    public boolean validateToken(String token) {
        return provider.validateToken(token);
    }

    public String extractUsername(String token) {
        return provider.getUsernameFromToken(token);
    }
}
