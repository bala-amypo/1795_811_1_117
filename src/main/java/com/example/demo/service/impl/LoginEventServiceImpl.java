package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repository;
    private final RuleEvaluationUtil evaluator;

    public LoginEventServiceImpl(LoginEventRepository repository, RuleEvaluationUtil evaluator) {
        this.repository = repository;
        this.evaluator = evaluator;
    }

    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = repository.save(event);
        evaluator.evaluateLoginEvent(saved);
        return saved;
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repository.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return repository.findAll();
    }
}
