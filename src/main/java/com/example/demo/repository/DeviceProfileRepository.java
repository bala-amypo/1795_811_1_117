package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {

    Optional<DeviceProfile> findByDeviceId(String deviceId);

    List<DeviceProfile> findByUserId(Long userId);
}
