package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Cage;

import java.util.List;
import java.util.Optional;

public interface CageRepository {
    List<Cage> getAll();

    Optional<Cage> getCage(int cageId);

    Cage save(Cage cage);

    void delete(int cageId);
}
