package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;

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
            if (event.getLoginStatus().equalsIgnoreCase(rule.getConditionsJson())) {
                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setPolicyRuleId(rule.getId());
                v.setEventId(event.getId());
                v.setViolationType("LOGIN_POLICY_BREACH");
                v.setDetails("Policy violated: " + rule.getDescription());
                v.setSeverity(rule.getSeverity());
                v.setResolved(false);
                violationRepo.save(v);
            }
        }
    }
}