package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoginEvent;

public interface LoginEventService {

    LoginEvent recordLogin(LoginEvent loginEvent);

    List<LoginEvent> getEventsByUser(Long userId);

    List<LoginEvent> getSuspiciousLogins(Long userId);

    List<LoginEvent> getAllEvents();
}
