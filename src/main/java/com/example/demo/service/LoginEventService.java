package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoginEvent;

public interface LoginEventService {

    LoginEvent saveLoginEvent(LoginEvent loginEvent);

    List<LoginEvent> getLoginEventsByUser(Long userId);

    List<LoginEvent> getAllLoginEvents();
}
