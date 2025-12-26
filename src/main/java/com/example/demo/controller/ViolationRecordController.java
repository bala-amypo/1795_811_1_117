package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordRepository repository;

    public ViolationRecordController(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ViolationRecord create(@RequestBody ViolationRecord violationRecord) {
        return repository.save(violationRecord);
    }

    @GetMapping
    public List<ViolationRecord> getAll() {
        return repository.findAll();
    }
}
