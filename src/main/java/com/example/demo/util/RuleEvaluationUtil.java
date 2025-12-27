package com.example.demo.util;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    // Example method to get all active rule codes
    public void evaluateActiveRules() {
        // Make sure your repository has findByActiveTrue() method
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : activeRules) {
            // Corrected getter
            String code = rule.getCode();
            System.out.println("Evaluating rule: " + code);
            // Your evaluation logic here
        }
    }
}
