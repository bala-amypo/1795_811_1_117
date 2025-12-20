package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    public UserAccount createUser(UserAccount userAccount) {
        return repository.save(userAccount);
    }

    public UserAccount getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = repository.findById(id).orElse(null);
        user.setStatus(status);
        return repository.save(user);
    }

    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }
}
