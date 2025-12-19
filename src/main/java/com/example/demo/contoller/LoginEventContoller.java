package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

@RestController
@RequestMapping("/login-events")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping
    public LoginEvent saveLoginEvent(@RequestBody LoginEvent loginEvent) {
        return loginEventService.saveLoginEvent(loginEvent);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getEventsByUserId(@PathVariable Long userId) {
        return loginEventService.getEventsByUserId(userId);
    }
}
