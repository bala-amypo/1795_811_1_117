package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;

import java.util.List;

public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    public ViolationRecord logViolation(ViolationRecord v) {
        return repo.save(v);
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = repo.findById(id).orElse(null);
        if (v == null) return null;
        v.setResolved(true);
        return repo.save(v);
    }
}
