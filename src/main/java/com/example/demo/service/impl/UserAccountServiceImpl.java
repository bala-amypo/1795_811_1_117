package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public UserAccount createUser(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public UserAccount getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = repo.findById(id).orElse(null);
        if (u == null) return null;
        u.setStatus(status);
        return repo.save(u);
    }
}
