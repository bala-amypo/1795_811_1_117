package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

import java.util.List;
import java.util.Optional;

public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    public DeviceProfile registerDevice(DeviceProfile device) {
        return repository.save(device);
    }

    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = repository.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(trust);
            return repository.save(device);
        }
        return null;
    }

    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId);
    }
}
