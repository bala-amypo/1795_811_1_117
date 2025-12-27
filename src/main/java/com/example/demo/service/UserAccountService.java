package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.Optional;

public interface UserAccountService {
    UserAccount getUserById(Long id);  // return type must match
    Optional<UserAccount> findByUsername(String username);
}
