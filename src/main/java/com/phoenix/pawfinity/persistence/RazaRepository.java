package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Breed;
import com.phoenix.pawfinity.domain.repository.BreedRepository;
import com.phoenix.pawfinity.persistence.crud.RazaCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Raza;
import com.phoenix.pawfinity.persistence.mapper.BreedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RazaRepository implements BreedRepository {
    @Autowired
    private RazaCrudRepository razaCrudRepository;
    @Autowired
    private BreedMapper mapper;

    @Override
    public List<Breed> getAll() {
        List<Raza> razas = (List<Raza>) razaCrudRepository.findAll();
        return mapper.toBreeds(razas);
    }

    @Override
    public Optional<Breed> getBreed(int breedId) {
        return razaCrudRepository.findById(breedId).map(raza -> mapper.toBreed(raza));
    }

    @Override
    public Breed save(Breed breed) {
        Raza raza = mapper.toRaza(breed);
        return mapper.toBreed(razaCrudRepository.save(raza));
    }

    @Override
    public void delete(int breedId) {
        razaCrudRepository.deleteById(breedId);
    }
}
