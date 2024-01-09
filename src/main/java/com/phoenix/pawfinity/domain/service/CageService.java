package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Cage;
import com.phoenix.pawfinity.domain.repository.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CageService {
    @Autowired
    private CageRepository cageRepository;

    public List<Cage> getAll() {
        return cageRepository.getAll();
    }

    public Optional<Cage> getCage(int cageId) {
        return cageRepository.getCage(cageId);
    }

    public Cage save(Cage cage) {
        return cageRepository.save(cage);
    }

    public boolean delete(int cageId) {
        return getCage(cageId).map(cage -> {
            cageRepository.delete(cageId);
            return true;
        }).orElse(false);
    }
}
