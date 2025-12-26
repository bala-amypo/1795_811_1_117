package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login-events")
public class LoginEventController {

    private final LoginEventRepository repository;

    public LoginEventController(LoginEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public LoginEvent create(@RequestBody LoginEvent loginEvent) {
        return repository.save(loginEvent);
    }

    @GetMapping
    public List<LoginEvent> getAll() {
        return repository.findAll();
    }
}
