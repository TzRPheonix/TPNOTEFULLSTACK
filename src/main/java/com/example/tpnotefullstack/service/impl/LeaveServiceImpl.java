package com.example.tpnotefullstack.service.impl;

import com.example.tpnotefullstack.model.Leave;
import com.example.tpnotefullstack.repository.LeaveRepository;
import com.example.tpnotefullstack.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveRepository leaveRepository;
    @Override
    public List<Leave> findAll() {
        return leaveRepository.findAll();
    }

    @Override
    public Optional<Leave> findById(Long id) {
        return leaveRepository.findById(id);
    }

    @Override
    public Leave save(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public void deleteById(Long id) {
        leaveRepository.deleteById(id);
    }
}
