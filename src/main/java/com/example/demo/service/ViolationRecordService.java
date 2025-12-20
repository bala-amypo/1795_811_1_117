package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ViolationRecord;

public interface ViolationRecordService {

    ViolationRecord logViolation(ViolationRecord violationRecord);

    ViolationRecord markResolved(Long id);

    List<ViolationRecord> getViolationsByUser(Long userId);

    List<ViolationRecord> getUnresolvedViolations();
}
