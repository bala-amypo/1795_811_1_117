package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository policyRuleRepository;

    public PolicyRuleServiceImpl(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return policyRuleRepository.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existingRule = policyRuleRepository.findById(id).orElse(null);
        if (existingRule != null) {
            existingRule.setRuleCode(rule.getRuleCode());
            existingRule.setDescription(rule.getDescription());
            existingRule.setSeverity(rule.getSeverity());
            existingRule.setConditionsJson(rule.getConditionsJson());
            existingRule.setActive(rule.getActive());
            return policyRuleRepository.save(existingRule);
        }
        return null;
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return policyRuleRepository.findByActiveTrue();
    }

    @Override
    public PolicyRule getRuleByCode(String ruleCode) {
        return policyRuleRepository.findByRuleCode(ruleCode).orElse(null);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return policyRuleRepository.findAll();
    }
}