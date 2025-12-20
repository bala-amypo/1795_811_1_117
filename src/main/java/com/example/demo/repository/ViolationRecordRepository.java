package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ViolationRecord;

public interface ViolationRecordRepository extends JpaRepository<ViolationRecord, Long> {

    List<ViolationRecord> findByUserId(Long userId);

    List<ViolationRecord> findByResolvedFalse();
}
