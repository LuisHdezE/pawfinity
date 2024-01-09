package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Species;
import com.phoenix.pawfinity.domain.repository.SpeciesRepository;
import com.phoenix.pawfinity.persistence.crud.EspecieCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Especie;
import com.phoenix.pawfinity.persistence.mapper.SpeciesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EspecieRepository implements SpeciesRepository {
    @Autowired
    private EspecieCrudRepository especieCrudRepository;
    @Autowired
    private SpeciesMapper mapper;

    @Override
    public List<Species> getAll() {
        List<Especie> especies = (List<Especie>) especieCrudRepository.findAll();
        return mapper.toSpecies(especies);
    }

    @Override
    public Optional<Species> getSpecies(int speciesId) {
        return especieCrudRepository.findById(speciesId).map(especie -> mapper.toSpecie(especie));
    }

    @Override
    public Species save(Species species) {
        Especie especie = mapper.toEspecie(species);
        return mapper.toSpecie(especieCrudRepository.save(especie));
    }

    @Override
    public void delete(int speciesId) {
        especieCrudRepository.deleteById(speciesId);
    }
}
