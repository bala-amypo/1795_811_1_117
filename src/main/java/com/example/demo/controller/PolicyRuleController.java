package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "PolicyRuleController", description = "Policy rules APIs")
public class PolicyRuleController {

    @PostMapping
    public String createRule(@RequestBody Object rule) {
        return "Rule created";
    }

    @PutMapping("/{id}")
    public String updateRule(@PathVariable Long id, @RequestBody Object rule) {
        return "Rule " + id + " updated";
    }

    @GetMapping("/active")
    public List<String> getActiveRules() {
        return new ArrayList<>();
    }

    @GetMapping
    public List<String> getAllRules() {
        return new ArrayList<>();
    }
}
