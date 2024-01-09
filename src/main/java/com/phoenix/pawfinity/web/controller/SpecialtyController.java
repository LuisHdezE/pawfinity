package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Specialty;
import com.phoenix.pawfinity.domain.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Specialtys")
public class SpecialtyController {
    @Autowired
    private SpecialtyService service;
    @GetMapping("/all")
    public List<Specialty> getAll(){
        return service.getAll();
    }
    @GetMapping("/{specialtyId}")
    public Optional<Specialty> getSpecialty(@PathVariable("specialtyId") int specialtyId){
        return service.getSpecialty(specialtyId);
    }
    @PostMapping("/save")
    public Specialty save(@RequestBody Specialty specialty){
        return service.save(specialty);
    }
    @DeleteMapping("/delete/{specialtyId}")
    public boolean delete(@PathVariable("specialtyId") int specialtyId){
        return service.delete(specialtyId);
    }

}
