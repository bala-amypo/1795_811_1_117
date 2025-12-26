package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceProfileRepository;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceProfileRepository) {
        this.deviceProfileRepository = deviceProfileRepository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return deviceProfileRepository.save(device);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = deviceProfileRepository.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(trust);
            return deviceProfileRepository.save(device);
        }
        return null;
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return deviceProfileRepository.findByUserId(userId);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceProfileRepository.findByDeviceId(deviceId);
    }
}