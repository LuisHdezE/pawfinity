package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Specialty;

import java.util.List;
import java.util.Optional;

public interface SpecialtyRepository {
    List<Specialty> getAll();

    Optional<Specialty> getSpecialty(int specialtyId);

    Specialty save(Specialty specialty);

    void delete(int specialtyId);
}
