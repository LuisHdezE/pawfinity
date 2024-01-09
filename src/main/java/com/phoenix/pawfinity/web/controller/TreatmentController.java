package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Treatment;
import com.phoenix.pawfinity.domain.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Treatments")
public class TreatmentController {
    @Autowired
    private TreatmentService service;

    @GetMapping("/all")
    public List<Treatment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{treatmentId}")
    public Optional<Treatment> getTreatment(@PathVariable("treatmentId") int treatmentId) {
        return service.getTreatment(treatmentId);
    }

    @PostMapping("/save")
    public Treatment save(@RequestBody Treatment treatment) {
        return service.save(treatment);
    }

    @DeleteMapping("/delete/{treatmentId}")
    public boolean delete(@PathVariable("treatmentId") int treatmentId) {
        return service.delete(treatmentId);
    }
}
