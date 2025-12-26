package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {
    private final LoginEventRepository loginEventRepository;
    private final RuleEvaluationUtil ruleEvaluationUtil;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository, RuleEvaluationUtil ruleEvaluationUtil) {
        this.loginEventRepository = loginEventRepository;
        this.ruleEvaluationUtil = ruleEvaluationUtil;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = loginEventRepository.save(event);
        ruleEvaluationUtil.evaluateLoginEvent(saved);
        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginEventRepository.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return loginEventRepository.findAll();
    }
}