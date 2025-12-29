// // package com.example.demo.entity;

// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;

// // @Entity
// // public class LoginEvent {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private Long userId;
// //     private String ipAddress;
// //     private String location;
// //     private String deviceId;
// //     private LocalDateTime timestamp;
// //     private String loginStatus;

// //     public LoginEvent() {}

// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public Long getUserId() { return userId; }
// //     public void setUserId(Long userId) { this.userId = userId; }

// //     public String getIpAddress() { return ipAddress; }
// //     public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

// //     public String getLocation() { return location; }
// //     public void setLocation(String location) { this.location = location; }

// //     public String getDeviceId() { return deviceId; }
// //     public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

// //     public LocalDateTime getTimestamp() { return timestamp; }
// //     public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

// //     public String getLoginStatus() { return loginStatus; }
// //     public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }
// // }


// // // package com.example.demo.entity;

// // // import java.time.LocalDateTime;
// // // import jakarta.persistence.Entity;
// // // import jakarta.persistence.Id;
// // // import jakarta.persistence.GeneratedValue;
// // // import jakarta.persistence.GenerationType;

// // // @Entity 

// // // public class LoginEvent {
    
// // //     @Id
// // //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// // //     private Long id;
// // //     private Long userId;
// // //     private String ipAddress;
// // //     private String location;
// // //     private String deviceId;
// // //     private LocalDateTime timestamp;
// // //     private String loginStatus;

// // //     public LoginEvent() {}

// // //     public Long getId() { return id; }
// // //     public void setId(Long id) { this.id = id; }

// // //     public Long getUserId() { return userId; }
// // //     public void setUserId(Long userId) { this.userId = userId; }

// // //     public String getIpAddress() { return ipAddress; }
// // //     public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

// // //     public String getLocation() { return location; }
// // //     public void setLocation(String location) { this.location = location; }

// // //     public String getDeviceId() { return deviceId; }
// // //     public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

// // //     public LocalDateTime getTimestamp() { return timestamp; }
// // //     public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

// // //     public String getLoginStatus() { return loginStatus; }
// // //     public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }
// // // }


// package com.example.demo.entity;

// import java.time.LocalDateTime;

// public class LoginEvent {
//     private Long id;
//     private Long userId;
//     private String loginStatus;
//     private String ipAddress;
//     private String deviceId;
//     private String location;
//     private LocalDateTime timestamp;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getUserId() { return userId; }
//     public void setUserId(Long userId) { this.userId = userId; }

//     public String getLoginStatus() { return loginStatus; }
//     public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }

//     public String getIpAddress() { return ipAddress; }
//     public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

//     public String getDeviceId() { return deviceId; }
//     public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

//     public String getLocation() { return location; }
//     public void setLocation(String location) { this.location = location; }

//     public LocalDateTime getTimestamp() { return timestamp; }
//     public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
// }

package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String status;
    private String employeeId;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}