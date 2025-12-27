package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;

import java.util.List;
import java.util.Optional;
@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    public PolicyRule createRule(PolicyRule rule) {
        return repository.save(rule);
    }

    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = repository.findById(id).orElse(null);
        if (existing != null) {
            rule.setId(id);
            return repository.save(rule);
        }
        return null;
    }

    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public Optional<PolicyRule> getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }

    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }
}
