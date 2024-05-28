package com.example.tpnotefullstack.service;

import com.example.tpnotefullstack.model.Absence;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {
    List<Absence> findAll();

    Optional<Absence> findById(Long id);

    Absence save(Absence absence);

    void deleteById(Long id);
}
