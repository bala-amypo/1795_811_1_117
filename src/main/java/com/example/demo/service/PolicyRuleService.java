package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PolicyRule;

public interface PolicyRuleService {

    PolicyRule createRule(PolicyRule policyRule);

    PolicyRule updateRule(Long id, PolicyRule policyRule);

    List<PolicyRule> getActiveRules();

    List<PolicyRule> getAllRules();
}
