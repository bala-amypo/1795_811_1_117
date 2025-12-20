package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;

    public LoginEventServiceImpl(LoginEventRepository repo) {
        this.repo = repo;
    }

    public LoginEvent recordLogin(LoginEvent event) {
        return repo.save(event);
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
    }
}
