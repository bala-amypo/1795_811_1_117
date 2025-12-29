package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class PolicyRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleCode;
    private String description;
    private String conditionsJson; 
    private String severity;
    private Boolean active = true;
}