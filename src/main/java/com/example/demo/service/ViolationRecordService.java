package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ViolationRecord;

public interface ViolationRecordService {

    ViolationRecord saveViolation(ViolationRecord violationRecord);

    List<ViolationRecord> getViolationsByUserId(Long userId);
}
