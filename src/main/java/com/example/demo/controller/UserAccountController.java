package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(userService.updateUserStatus(id, status));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserAccount>> listAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}