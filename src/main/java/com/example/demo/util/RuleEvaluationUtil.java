package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule r : rules) {
            if (event.getLoginStatus() != null && r.getConditionsJson() != null) {
                if (event.getLoginStatus().contains("FAILED") && r.getConditionsJson().contains("FAILED")) {
                    ViolationRecord v = new ViolationRecord();
                    v.setUserId(event.getUserId());
                    v.setEventId(event.getId());
                    v.setSeverity(r.getSeverity());
                    v.setDetails("Rule triggered");
                    v.setResolved(false);
                    v.setTimestamp(LocalDateTime.now());
                    violationRepo.save(v);
                }
            }
        }
    }
}
