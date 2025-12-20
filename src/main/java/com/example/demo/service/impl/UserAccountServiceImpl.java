package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount createUser(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    public UserAccount getUserById(Long id) {
        return userAccountRepository.findById(id).orElse(null);
    }

    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }
}
