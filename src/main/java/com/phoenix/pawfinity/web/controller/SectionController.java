package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Section;
import com.phoenix.pawfinity.domain.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Sections")
public class SectionController {
    @Autowired
    private SectionService service;

    @GetMapping("/all")
    public List<Section> getAll() {
        return service.getAll();
    }

    @GetMapping("/{sectionId}")
    public Optional<Section> getSection(@PathVariable("sectionId") int sectionId) {
        return service.getSection(sectionId);
    }

    @PostMapping("/save")
    public Section save(@RequestBody Section section) {
        return service.save(section);
    }

    @DeleteMapping("/delete/{sectionId}")
    public boolean delete(@PathVariable("sectionId") int sectionId) {
        return service.delete(sectionId);
    }
}
