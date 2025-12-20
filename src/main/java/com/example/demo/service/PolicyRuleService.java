package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PolicyRule;

public interface PolicyRuleService {

    PolicyRule savePolicyRule(PolicyRule policyRule);

    List<PolicyRule> getAllPolicyRules();
}
