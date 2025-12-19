package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository) {
        this.loginEventRepository = loginEventRepository;
    }

    public LoginEvent saveLoginEvent(LoginEvent loginEvent) {
        return loginEventRepository.save(loginEvent);
    }

    public List<LoginEvent> getEventsByUserId(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }
}
