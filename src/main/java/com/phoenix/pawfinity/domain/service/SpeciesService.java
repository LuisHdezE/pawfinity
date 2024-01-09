package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Species;
import com.phoenix.pawfinity.domain.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;
    public List<Species> getAll(){
        return speciesRepository.getAll();
    }

    public Optional<Species> getSpecies(int speciesId){
        return speciesRepository.getSpecies(speciesId);
    }

    public Species save(Species species){
        return speciesRepository.save(species);
    }

    public boolean delete(int speciesId){
        return getSpecies(speciesId).map(species -> {
            speciesRepository.delete(speciesId);
            return true;
        }).orElse(false);
    }
}
