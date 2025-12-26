package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-accounts")
public class UserAccountController {

    private final UserAccountRepository repository;

    public UserAccountController(UserAccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount userAccount) {
        return repository.save(userAccount);
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return repository.findAll();
    }
}
