package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRecordRepository;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRecordRepository) {
        this.violationRecordRepository = violationRecordRepository;
    }

    public ViolationRecord saveViolation(ViolationRecord violationRecord) {
        return violationRecordRepository.save(violationRecord);
    }

    public List<ViolationRecord> getViolationsByUserId(Long userId) {
        return violationRecordRepository.findByUserId(userId);
    }
}
