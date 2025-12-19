package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;

@RestController
@RequestMapping("/policies")
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    @PostMapping
    public PolicyRule savePolicy(@RequestBody PolicyRule policyRule) {
        return policyRuleService.saveRule(policyRule);
    }

    @GetMapping
    public List<PolicyRule> getActivePolicies() {
        return policyRuleService.getActiveRules();
    }
}
