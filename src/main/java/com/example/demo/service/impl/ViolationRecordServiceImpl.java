package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;

import java.util.List;

public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    public ViolationRecord logViolation(ViolationRecord violation) {
        return repository.save(violation);
    }

    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = repository.findById(id).orElse(null);
        if (v != null) {
            v.setResolved(true);
            return repository.save(v);
        }
        return null;
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return repository.findByResolvedFalse();
    }

    public List<ViolationRecord> getAllViolations() {
        return repository.findAll();
    }
}
