package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public PolicyRule updateRule(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public Optional<PolicyRule> getRuleById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PolicyRule getRuleByCode(String code) {
        return repository.findByCode(code).orElse(null);
    }
}
