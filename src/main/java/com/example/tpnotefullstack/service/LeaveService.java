package com.example.tpnotefullstack.service;

import com.example.tpnotefullstack.model.Leave;

import java.util.List;
import java.util.Optional;

public interface LeaveService {
    List<Leave> findAll();

    Optional<Leave> findById(Long id);

    Leave save(Leave leave);

    void deleteById(Long id);
}
