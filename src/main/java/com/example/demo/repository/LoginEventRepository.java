package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {

    // Custom query method to find suspicious logins by userId
    List<LoginEvent> findSuspiciousByUserId(Long userId);
}
