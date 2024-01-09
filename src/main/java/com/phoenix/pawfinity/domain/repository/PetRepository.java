package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    List<Pet> getAll();

    Optional<Pet> getPet(int petId);

    Pet save(Pet pet);

    void delete(int petId);
}
