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
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCode(rule.getCode());
            existing.setDescription(rule.getDescription());
            existing.setActive(rule.getActive());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public Optional<PolicyRule> getRuleByCode(String ruleCode) {
        return repository.findByCode(ruleCode);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }
}
