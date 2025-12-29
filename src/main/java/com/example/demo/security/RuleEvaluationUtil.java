package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;

public class RuleEvaluationUtil {
    private PolicyRuleRepository ruleRepo;
    private ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();
        for (PolicyRule rule : activeRules) {
            // Logic: if rule condition (e.g. "FAILED") matches login status, trigger violation
            if (rule.getConditionsJson() != null && rule.getConditionsJson().contains(event.getLoginStatus())) {
                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setEventId(event.getId());
                v.setSeverity(rule.getSeverity());
                v.setDetails("Policy Violation: " + rule.getRuleCode());
                violationRepo.save(v);
            }
        }
    }
}