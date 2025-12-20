package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    DeviceProfile updateTrustStatus(Long id, boolean trust);

    List<DeviceProfile> getDevicesByUser(Long userId);

    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
