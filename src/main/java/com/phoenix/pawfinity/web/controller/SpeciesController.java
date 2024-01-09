package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Species;
import com.phoenix.pawfinity.domain.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Species")
public class SpeciesController {
    @Autowired
    private SpeciesService service;
    @GetMapping("/all")
    public List<Species> getAll(){
        return service.getAll();
    }
    @GetMapping("/{speciesId}")
    public Optional<Species> getSpecies(@PathVariable("speciesId") int speciesId){
        return service.getSpecies(speciesId);
    }
    @PostMapping("/save")
    public Species save(@RequestBody Species species){
        return service.save(species);
    }
   @DeleteMapping("/delete/{speciesId}")
   public boolean delete(@PathVariable("speciesId") int speciesId){
        return service.delete(speciesId);
    }

}
