package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public UserAccount createUser(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public UserAccount getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return repository.save(user);
        }
        return null;
    }

    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserAccount> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
