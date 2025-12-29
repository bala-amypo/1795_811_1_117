// package com.example.demo.controller;

// import com.example.demo.entity.*;
// import com.example.demo.service.*;
// import org.springframework.http.*;

// public class DeviceProfileController {
//     private final DeviceProfileService service;
//     public DeviceProfileController(DeviceProfileService service) {
//         this.service = service;
//     }
//     public ResponseEntity<DeviceProfile> lookup(String id) {
//         return ResponseEntity.ok(service.findByDeviceId(id).orElse(null));
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {
    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestParam Boolean isTrusted) {
        return ResponseEntity.ok(service.updateTrustStatus(id, isTrusted));
    }
}