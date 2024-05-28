package com.example.tpnotefullstack.service.impl;

import com.example.tpnotefullstack.model.Absence;
import com.example.tpnotefullstack.repository.AbsenceRepository;
import com.example.tpnotefullstack.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceServiceImpl implements AbsenceService {
    @Autowired
    AbsenceRepository absenceRepository;
    @Override
    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    @Override
    public Optional<Absence> findById(Long id) {
        return absenceRepository.findById(id);
    }

    @Override
    public Absence save(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public void deleteById(Long id) {
        absenceRepository.deleteById(id);
    }
}
