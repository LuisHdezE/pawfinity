package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Vaccine;
import com.phoenix.pawfinity.domain.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineService {
    @Autowired
    private VaccineRepository vaccineRepository;

    public List<Vaccine> getAll() {
        return vaccineRepository.getAll();
    }

    public Optional<Vaccine> getVaccine(int vaccineId) {
        return vaccineRepository.getVaccine(vaccineId);
    }

    public Vaccine save(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    public boolean delete(int vaccineId) {
        return getVaccine(vaccineId).map(vaccine -> {
            vaccineRepository.delete(vaccineId);
            return true;
        }).orElse(false);
    }
}
