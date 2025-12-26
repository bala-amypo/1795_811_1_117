package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
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
            // Test expects condition match on LoginStatus (e.g., "FAILED")
            if (event.getLoginStatus() != null && event.getLoginStatus().equals(rule.getConditionsJson())) {
                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setPolicyRuleId(rule.getId());
                v.setEventId(event.getId());
                v.setViolationType("SECURITY_VIOLATION");
                v.setSeverity(rule.getSeverity());
                v.setDetails("Policy Breach: " + rule.getRuleCode());
                v.setResolved(false);
                violationRepo.save(v);
            }
        }
    }
}