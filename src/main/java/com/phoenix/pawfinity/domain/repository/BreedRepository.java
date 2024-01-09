package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Breed;

import java.util.List;
import java.util.Optional;

public interface BreedRepository {
    List<Breed> getAll();

    Optional<Breed> getBreed(int breedId);

    Breed save(Breed breed);

    void delete(int breedId);
}
