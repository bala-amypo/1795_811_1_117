package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/logins")
@Tag(name = "LoginEventController", description = "Login events APIs")
public class LoginEventController {

    @PostMapping("/record")
    public String logLogin(@RequestBody Object loginEvent) {
        return "Login recorded";
    }

    @GetMapping("/user/{userId}")
    public List<String> getUserLogins(@PathVariable Long userId) {
        return new ArrayList<>();
    }

    @GetMapping("/suspicious/{userId}")
    public List<String> getSuspiciousLogins(@PathVariable Long userId) {
        return new ArrayList<>();
    }

    @GetMapping
    public List<String> getAllLogins() {
        return new ArrayList<>();
    }
}
