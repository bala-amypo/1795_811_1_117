package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile saveDevice(DeviceProfile deviceProfile);

    List<DeviceProfile> getDevicesByUser(Long userId);

    List<DeviceProfile> getAllDevices();
}
