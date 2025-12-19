package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/users")
@Tag(name = "UserAccountController", description = "Manage users")
public class UserAccountController {

    @PostMapping
    public String createUser(@RequestBody Object user) {
        return "User created";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return "Get user by id: " + id;
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestBody String status) {
        return "User " + id + " status updated to " + status;
    }

    @GetMapping
    public List<String> getAllUsers() {
        return new ArrayList<>();
    }
}
