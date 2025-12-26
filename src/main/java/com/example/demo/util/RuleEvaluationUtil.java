package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component; // ADD THIS IMPORT
import java.util.List;

@Component // ADD THIS ANNOTATION
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    // Spring will now automatically inject these repositories into this constructor
    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();
        for (PolicyRule rule : activeRules) {
            // Logic to check conditions
            if (event.getLoginStatus() != null && event.getLoginStatus().equalsIgnoreCase(rule.getConditionsJson())) {
                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setPolicyRuleId(rule.getId());
                v.setEventId(event.getId());
                v.setViolationType("IT_POLICY_VIOLATION");
                v.setDetails("Policy violated: " + rule.getDescription());
                v.setSeverity(rule.getSeverity());
                v.setResolved(false);
                violationRepo.save(v);
            }
        }
    }
}