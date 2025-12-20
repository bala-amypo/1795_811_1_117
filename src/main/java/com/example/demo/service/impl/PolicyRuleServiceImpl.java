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

    @Override
    public PolicyRule createRule(PolicyRule policyRule) {
        return repository.save(policyRule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule policyRule) {
        PolicyRule existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setRuleCode(policyRule.getRuleCode());
            existing.setDescription(policyRule.getDescription());
            existing.setActive(policyRule.isActive());
        }

        return repository.save(existing);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }
}
