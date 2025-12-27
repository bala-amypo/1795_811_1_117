package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service; // ✅ required

import java.util.List;
import java.util.Optional;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repository;

    public LoginEventServiceImpl(LoginEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoginEvent registerLogin(LoginEvent event) {
        return repository.save(event);
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Optional<LoginEvent> findById(Long id) {
        return repository.findById(id);
    }
}
