package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Vaccine;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository {
    List<Vaccine> getAll();

    Optional<Vaccine> getVaccine(int vaccineId);

    Vaccine save(Vaccine vaccine);

    void delete(int vaccineId);
}
