package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private String secret = "TestSecretKeyForJWT1234567890TestSecretKeyForJWT1234567890";
    private long validityInMs = 3600000;

    public JwtUtil() {}

    public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username, Long userId, String email, String role) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("userId", userId);
        claims.put("email", email);
        claims.put("role", role);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public String getEmail(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().get("email", String.class);
    }

    public String getRole(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().get("role", String.class);
    }

    public Long getUserId(String token) {
        Object val = Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().get("userId");
        return (val instanceof Integer) ? ((Integer) val).longValue() : (Long) val;
    }
}