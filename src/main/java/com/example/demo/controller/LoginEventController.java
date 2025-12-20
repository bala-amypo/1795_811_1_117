package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event) {
        return service.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> byUser(@PathVariable Long userId) {
        return service.getEventsByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> suspicious(@PathVariable Long userId) {
        return service.getSuspiciousLogins(userId);
    }

    @GetMapping
    public List<LoginEvent> all() {
        return service.getAllEvents();
    }
}
