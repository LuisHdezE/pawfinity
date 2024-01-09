package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Breed;
import com.phoenix.pawfinity.domain.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedService {
    @Autowired
    private BreedRepository breedRepository;

    public List<Breed> getAll() {
        return breedRepository.getAll();
    }

    public Optional<Breed> getBreed(int breedId) {
        return breedRepository.getBreed(breedId);
    }

    public Breed save(Breed breed) {
        return breedRepository.save(breed);
    }

    public boolean delete(int breedId) {
        return getBreed(breedId).map(breed -> {
            breedRepository.delete(breedId);
            return true;
        }).orElse(false);
    }

}
