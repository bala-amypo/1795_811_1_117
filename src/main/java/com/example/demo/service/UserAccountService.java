package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount createUser(UserAccount userAccount);

    UserAccount getUserById(Long id);

    List<UserAccount> getAllUsers();
}
