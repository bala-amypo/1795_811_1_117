package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repository.findById(id).orElse(null); // matches interface return type
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return repository.findByUsername(username); // Optional<UserAccount>
    }
}
