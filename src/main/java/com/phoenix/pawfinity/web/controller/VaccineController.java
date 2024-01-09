package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Vaccine;
import com.phoenix.pawfinity.domain.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Vaccines")
public class VaccineController {
    @Autowired
    private VaccineService service;

    @GetMapping("/all")
    public List<Vaccine> getAll() {
        return service.getAll();
    }

    @GetMapping("/{vaccineId}")
    public Optional<Vaccine> getVaccine(@PathVariable("vaccineId")int vaccineId) {
        return service.getVaccine(vaccineId);
    }

    @PostMapping("/save")
    public Vaccine save(@RequestBody Vaccine vaccine) {
        return service.save(vaccine);
    }

    @DeleteMapping("/delete/{vaccineId}")
    public boolean delete(@PathVariable("vaccineId") int vaccineId) {
        return service.delete(vaccineId);
    }

}
