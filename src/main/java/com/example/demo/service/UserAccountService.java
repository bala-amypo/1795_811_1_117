// // package com.example.demo.service;

// // import com.example.demo.entity.UserAccount;
// // import java.util.*;

// // public interface UserAccountService {
// //     UserAccount createUser(UserAccount user);
// //     UserAccount getUserById(Long id);
// //     UserAccount updateUserStatus(Long id, String status);
// //     List<UserAccount> getAllUsers();
// //     Optional<UserAccount> findByUsername(String username);
// // }

// package com.example.demo.service;

// import com.example.demo.entity.*;
// import java.util.*;

// public interface UserAccountService {
//     UserAccount createUser(UserAccount u);
//     UserAccount getUserById(Long id);
//     UserAccount updateUserStatus(Long id, String status);
//     List<UserAccount> getAllUsers();
// }
package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserAccountController {
    private UserAccountService service;
    public UserAccountController(UserAccountService s) { this.service = s; }
    
    @PostMapping("/users")
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount u) {
        return ResponseEntity.ok(service.createUser(u));
    }
}

@RestController
public class DeviceProfileController {
    private DeviceProfileService service;
    public DeviceProfileController(DeviceProfileService s) { this.service = s; }

    @GetMapping("/devices/{id}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String id) {
        return service.findByDeviceId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}