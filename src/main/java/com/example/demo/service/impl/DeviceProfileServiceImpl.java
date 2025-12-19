package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceProfileRepository;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceProfileRepository) {
        this.deviceProfileRepository = deviceProfileRepository;
    }

    public DeviceProfile saveDevice(DeviceProfile deviceProfile) {
        return deviceProfileRepository.save(deviceProfile);
    }

    public List<DeviceProfile> getDevicesByUserId(Long userId) {
        return deviceProfileRepository.findByUserId(userId);
    }
}
