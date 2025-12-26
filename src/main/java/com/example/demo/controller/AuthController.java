package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserAccountService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil, PasswordEncoder encoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        UserAccount user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (encoder.matches(request.getPassword(), user.getPassword())) {
            // FIX: Use user.getEmail() and user.getRole() from the Entity
            String token = jwtUtil.generateToken(user.getUsername(), user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }
}