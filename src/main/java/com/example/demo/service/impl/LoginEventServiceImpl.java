package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repository;

    public LoginEventServiceImpl(LoginEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoginEvent createEvent(LoginEvent event) {
        return repository.save(event);
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public Optional<LoginEvent> getEventById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repository.findSuspiciousByUserId(userId); // make sure repository method exists
    }
}
