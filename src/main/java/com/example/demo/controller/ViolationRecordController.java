package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/violations")
@Tag(name = "ViolationRecordController", description = "Violation record APIs")
public class ViolationRecordController {

    @PostMapping
    public String logViolation(@RequestBody Object violation) {
        return "Violation logged";
    }

    @GetMapping("/user/{userId}")
    public List<String> getUserViolations(@PathVariable Long userId) {
        return new ArrayList<>();
    }

    @PutMapping("/{id}/resolve")
    public String resolveViolation(@PathVariable Long id) {
        return "Violation " + id + " resolved";
    }

    @GetMapping("/unresolved")
    public List<String> getUnresolvedViolations() {
        return new ArrayList<>();
    }

    @GetMapping
    public List<String> getAllViolations() {
        return new ArrayList<>();
    }
}
