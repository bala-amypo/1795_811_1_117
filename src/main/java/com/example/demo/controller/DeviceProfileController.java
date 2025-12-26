package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Profiles", description = "Operations on device profiles")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(deviceService.registerDevice(device));
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestBody Boolean isTrusted) {
        return ResponseEntity.ok(deviceService.updateTrustStatus(id, isTrusted));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(deviceService.getDevicesByUser(userId));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<Optional<DeviceProfile>> lookup(@PathVariable String deviceId) {
        return ResponseEntity.ok(deviceService.findByDeviceId(deviceId));
    }

    @GetMapping
    public ResponseEntity<List<DeviceProfile>> getAll() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }
}
