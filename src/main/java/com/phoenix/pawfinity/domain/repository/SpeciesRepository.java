package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Species;

import java.util.List;
import java.util.Optional;

public interface SpeciesRepository {
    List<Species> getAll();

    Optional<Species> getSpecies(int speciesId);

    Species save(Species species);

    void delete(int speciesId);
}
