package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.*;

public class DeviceProfileController {
    private final DeviceProfileService service;
    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }
    public ResponseEntity<DeviceProfile> lookup(String id) {
        return ResponseEntity.ok(service.findByDeviceId(id).orElse(null));
    }
}