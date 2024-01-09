package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Pet;
import com.phoenix.pawfinity.domain.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pets")
public class PetController {
    @Autowired
    private PetService service;

    @GetMapping("/all")
    public List<Pet> getAll() {
        return service.getAll();
    }

    @GetMapping("/{petId}")
    public Optional<Pet> getPet(@PathVariable("petId") int petId) {
        return service.getPet(petId);
    }

    @PostMapping("/save")
    public Pet save(@RequestBody Pet pet) {
        return service.save(pet);
    }

    @DeleteMapping("/delete/{petId}")
    public boolean delete(@PathVariable("petId") int petId) {
        return service.delete(petId);
    }
}
