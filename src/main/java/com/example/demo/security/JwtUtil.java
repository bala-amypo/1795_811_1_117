package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Arrays;

public class JwtUtil {
    private final Key key;
    private final long validity;

    public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
        this.validity = validityInMs;
        byte[] keyBytes = secret.getBytes();
        // Pad key to 64 bytes to ensure it works for HS256/HS384/HS512 in all modes
        byte[] paddedKey = new byte[64];
        System.arraycopy(keyBytes, 0, paddedKey, 0, Math.min(keyBytes.length, 64));
        this.key = Keys.hmacShaKeyFor(paddedKey);
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) { return false; }
    }

    public String getEmail(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("email", String.class);
    }

    public String getRole(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("role", String.class);
    }

    public Long getUserId(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("userId", Long.class);
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
}