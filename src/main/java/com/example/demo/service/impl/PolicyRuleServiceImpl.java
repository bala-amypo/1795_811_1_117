package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    public PolicyRule createRule(PolicyRule policyRule) {
        return repository.save(policyRule);
    }

    public PolicyRule updateRule(Long id, PolicyRule policyRule) {
        PolicyRule existing = repository.findById(id).orElse(null);

        existing.setRuleName(policyRule.getRuleName());
        existing.setDescription(policyRule.getDescription());
        existing.setActive(policyRule.isActive());

        return repository.save(existing);
    }

    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }
}
