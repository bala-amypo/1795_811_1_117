package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policy-rules")
public class PolicyRuleController {

    private final PolicyRuleRepository repository;

    public PolicyRuleController(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule policyRule) {
        return repository.save(policyRule);
    }

    @GetMapping
    public List<PolicyRule> getAll() {
        return repository.findAll();
    }
}
