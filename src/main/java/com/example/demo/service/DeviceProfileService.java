package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile deviceProfile);

    DeviceProfile updateTrustStatus(Long id, boolean trust);

    List<DeviceProfile> getDevicesByUser(Long userId);

    List<DeviceProfile> getAllDevices();
}
