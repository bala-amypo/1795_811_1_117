package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ViolationRecord;

public interface ViolationRecordService {

    ViolationRecord saveViolation(ViolationRecord violationRecord);

    List<ViolationRecord> getViolationsByUser(Long userId);

    List<ViolationRecord> getAllViolations();
}
