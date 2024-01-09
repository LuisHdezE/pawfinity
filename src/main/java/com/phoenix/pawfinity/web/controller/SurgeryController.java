package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Surgery;
import com.phoenix.pawfinity.domain.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Surgerys")
public class SurgeryController {
    @Autowired
    private SurgeryService service;

    @GetMapping("/all")
    public List<Surgery> getAll() {
        return service.getAll();
    }

    @GetMapping("/{surgeryId}")
    public Optional<Surgery> getSurgery(@PathVariable("surgeryId") int surgeryId) {
        return service.getSurgery(surgeryId);
    }

    @PostMapping("/save")
    public Surgery save(@RequestBody Surgery surgery) {
        return service.save(surgery);
    }

    @DeleteMapping("/delete/{surgeryId}")
    public boolean delete(@PathVariable("surgeryId") int surgeryId) {
        return service.delete(surgeryId);
    }
}
