package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest req) {
        UserAccount u = new UserAccount();
        u.setUsername(req.username);
        u.setPassword(req.password);
        u.setEmail(req.email);
        u.setEmployeeId(req.employeeId);
        u.setRole(req.role);
        return ResponseEntity.ok(userService.createUser(u));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        UserAccount u = userService.findByUsername(req.username);
        if (u != null && passwordEncoder.matches(req.password, u.getPassword())) {
            String token = jwtUtil.generateToken(u.getUsername(), u.getId(), u.getEmail(), u.getRole());
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}