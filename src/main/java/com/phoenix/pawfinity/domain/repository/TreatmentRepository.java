package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Treatment;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository {
    List<Treatment> getAll();

    Optional<Treatment> getTreatment(int treatmentId);

    Treatment save(Treatment treatment);

    void delete(int treatmentId);
}
