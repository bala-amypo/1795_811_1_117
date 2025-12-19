package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceProfileService;

    public DeviceProfileController(DeviceProfileService deviceProfileService) {
        this.deviceProfileService = deviceProfileService;
    }

    @PostMapping
    public DeviceProfile saveDevice(@RequestBody DeviceProfile deviceProfile) {
        return deviceProfileService.saveDevice(deviceProfile);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getDevicesByUserId(@PathVariable Long userId) {
        return deviceProfileService.getDevicesByUserId(userId);
    }
}
