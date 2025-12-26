package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
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
            if (event.getLoginStatus() != null && event.getLoginStatus().equalsIgnoreCase(rule.getConditionsJson())) {
                ViolationRecord violation = new ViolationRecord();
                violation.setUserId(event.getUserId());
                violation.setPolicyRuleId(rule.getId());
                violation.setEventId(event.getId());
                violation.setViolationType("IT_POLICY_VIOLATION");
                violation.setDetails("Violation detected based on rule: " + rule.getRuleCode());
                violation.setSeverity(rule.getSeverity());
                violation.setResolved(false);
                violationRepo.save(violation);
            }
        }
    }
}