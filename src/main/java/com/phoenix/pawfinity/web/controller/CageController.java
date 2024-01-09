package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Cage;
import com.phoenix.pawfinity.domain.service.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cages")
public class CageController {
    @Autowired
    private CageService service;

    @GetMapping("/all")
    public List<Cage> getAll() {
        return service.getAll();
    }

    @GetMapping("/{cageId}")
    public Optional<Cage> getCage(@PathVariable("cageId") int cageId) {
        return service.getCage(cageId);
    }

    @PostMapping("/save")
    public Cage save(@RequestBody Cage cage) {
        return service.save(cage);
    }

    @DeleteMapping("/delete/{cageId}")
    public boolean delete(@PathVariable("cageId") int cageId) {
        return service.delete(cageId);
    }
}
