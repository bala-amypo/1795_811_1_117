package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service; // ✅ required

import java.util.List;
import java.util.Optional;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViolationRecord createRecord(ViolationRecord record) {
        return repository.save(record);
    }

    @Override
    public ViolationRecord updateRecord(ViolationRecord record) {
        return repository.save(record);
    }

    @Override
    public List<ViolationRecord> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public Optional<ViolationRecord> getRecordById(Long id) {
        return repository.findById(id);
    }
}
