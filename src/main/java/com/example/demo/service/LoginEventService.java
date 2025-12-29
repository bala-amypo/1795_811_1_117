// // package com.example.demo.service;

// // import com.example.demo.entity.LoginEvent;
// // import java.util.*;

// // public interface LoginEventService {
// //     LoginEvent recordLogin(LoginEvent event);
// //     List<LoginEvent> getEventsByUser(Long userId);
// //     List<LoginEvent> getSuspiciousLogins(Long userId);
// //     List<LoginEvent> getAllEvents();
// // }
// package com.example.demo.service;

// import com.example.demo.entity.*;
// import java.util.*;
// public interface LoginEventService {
//     LoginEvent recordLogin(LoginEvent e);
//     List<LoginEvent> getEventsByUser(Long id);
//     List<LoginEvent> getSuspiciousLogins(Long id);
// }
package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    UserAccount createUser(UserAccount u);
    UserAccount getUserById(Long id);
    UserAccount updateUserStatus(Long id, String status);
    List<UserAccount> getAllUsers();
}

public interface LoginEventService {
    LoginEvent recordLogin(LoginEvent event);
    List<LoginEvent> getEventsByUser(Long userId);
    List<LoginEvent> getSuspiciousLogins(Long userId);
}

public interface DeviceProfileService {
    DeviceProfile registerDevice(DeviceProfile device);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    DeviceProfile updateTrustStatus(Long id, boolean isTrusted);
}

public interface PolicyRuleService {
    PolicyRule createRule(PolicyRule rule);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
}

public interface ViolationRecordService {
    ViolationRecord logViolation(ViolationRecord v);
    List<ViolationRecord> getUnresolvedViolations();
    ViolationRecord markResolved(Long id);
}