package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

@RestController
@RequestMapping("/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationRecordService;

    public ViolationRecordController(ViolationRecordService violationRecordService) {
        this.violationRecordService = violationRecordService;
    }

    @PostMapping
    public ViolationRecord saveViolation(@RequestBody ViolationRecord violationRecord) {
        return violationRecordService.saveViolation(violationRecord);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getViolationsByUserId(@PathVariable Long userId) {
        return violationRecordService.getViolationsByUserId(userId);
    }
}
