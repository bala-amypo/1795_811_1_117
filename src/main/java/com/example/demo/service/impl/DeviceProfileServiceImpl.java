package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    public DeviceProfile registerDevice(DeviceProfile deviceProfile) {
        return repository.save(deviceProfile);
    }

    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = repository.findById(id).orElse(null);
        device.setIsTrusted(trust);
        return repository.save(device);
    }

    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<DeviceProfile> getAllDevices() {
        return repository.findAll();
    }
}
