package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    public ViolationRecord logViolation(ViolationRecord violationRecord) {
        return repository.save(violationRecord);
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = repository.findById(id).orElse(null);
        record.setResolved(true);
        return repository.save(record);
    }

    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return repository.findByResolvedFalse();
    }

    public List<ViolationRecord> getAllViolations() {
        return repository.findAll();
    }
}
