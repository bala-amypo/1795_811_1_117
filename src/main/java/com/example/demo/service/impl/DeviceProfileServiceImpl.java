package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

import java.util.Optional;

public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    public DeviceProfile registerDevice(DeviceProfile device) {
        return repo.save(device);
    }

    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }

    public DeviceProfile updateTrustStatus(Long id, boolean trusted) {
        DeviceProfile d = repo.findById(id).orElse(null);
        if (d == null) return null;
        d.setIsTrusted(trusted);
        return repo.save(d);
    }
}
