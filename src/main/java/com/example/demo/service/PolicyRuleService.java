package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PolicyRule;

public interface PolicyRuleService {

    PolicyRule createRule(PolicyRule rule);

    PolicyRule updateRule(Long id, PolicyRule rule);

    List<PolicyRule> getActiveRules();

    List<PolicyRule> getAllRules();
}
