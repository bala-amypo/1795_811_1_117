package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) {

        if (username.equals("admin") && password.equals("admin")) {
            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.badRequest().body("Invalid Credentials");
    }
}
