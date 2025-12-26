package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logins")
@Tag(name = "LoginEvent")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping("/record")
    public ResponseEntity<LoginEvent> record(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(loginEventService.recordLogin(event));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getEventsByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> getSuspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getSuspiciousLogins(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<LoginEvent>> all() {
        return ResponseEntity.ok(loginEventService.getAllEvents());
    }
}