package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Breed;
import com.phoenix.pawfinity.domain.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Breeds")
public class BreedController {
    @Autowired
    private BreedService service;

    @GetMapping("/all")
    public List<Breed> getAll() {
        return service.getAll();
    }

    @GetMapping("/{breedId}")
    public Optional<Breed> getBreed(@PathVariable("breedId") int breedId) {
        return service.getBreed(breedId);
    }

    @PostMapping("/save")
    public Breed save(@RequestBody Breed breed) {
        return service.save(breed);
    }

    @DeleteMapping("/delete/{breedId}")
    public boolean delete(@PathVariable("breedId") int breedId) {
        return service.delete(breedId);
    }
}
