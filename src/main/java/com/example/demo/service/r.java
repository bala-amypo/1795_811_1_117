package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RuleEvaluationUtil {
    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();
        
        for (PolicyRule rule : activeRules) {
            // Simple logic: If the rule condition (e.g., "FAILED") matches the login status
            if (rule.getConditionsJson() != null && rule.getConditionsJson().equalsIgnoreCase(event.getLoginStatus())) {
                ViolationRecord violation = new ViolationRecord();
                violation.setUserId(event.getUserId());
                violation.setEventId(event.getId());
                violation.setSeverity(rule.getSeverity());
                violation.setDetails("Policy Violation Triggered: " + rule.getRuleCode());
                violation.setResolved(false);
                
                violationRepo.save(violation);
            }
        }
    }
}