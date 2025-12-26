package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
@Tag(name = "Login Events", description = "Operations on login events")
public class LoginEventController {

    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/record")
    public ResponseEntity<LoginEvent> recordLogin(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(loginService.recordLogin(event));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginService.getEventsByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> getSuspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(loginService.getSuspiciousLogins(userId));
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> getAll() {
        return ResponseEntity.ok(loginService.getAllEvents());
    }
}
