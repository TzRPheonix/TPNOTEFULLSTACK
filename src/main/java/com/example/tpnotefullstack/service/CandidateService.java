package com.example.tpnotefullstack.service;

import com.example.tpnotefullstack.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<Candidate> findAll();

    Optional<Candidate> findById(Long id);

    Candidate save(Candidate candidate);

    void deleteById(Long id);
}
