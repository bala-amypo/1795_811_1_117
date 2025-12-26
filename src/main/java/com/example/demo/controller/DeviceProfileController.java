package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-profiles")
public class DeviceProfileController {

    private final DeviceProfileRepository repository;

    public DeviceProfileController(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public DeviceProfile create(@RequestBody DeviceProfile deviceProfile) {
        return repository.save(deviceProfile);
    }

    @GetMapping
    public List<DeviceProfile> getAll() {
        return repository.findAll();
    }
}
