package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "AuthController", description = "Authentication APIs")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody Object user) {
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody Object login) {
        return "User logged in";
    }
}
