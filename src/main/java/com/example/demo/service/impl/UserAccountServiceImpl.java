package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service; // ✅ required

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public UserAccount updateUser(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return repository.findById(id);
    }
}
