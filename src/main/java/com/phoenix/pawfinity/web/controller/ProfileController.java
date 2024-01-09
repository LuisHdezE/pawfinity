package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Profile;
import com.phoenix.pawfinity.domain.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Profiles")
public class ProfileController {
    @Autowired
    private ProfileService service;

    @GetMapping("/all")
    public List<Profile> getAll() {
        return service.getAll();
    }

    @GetMapping("/{profileId}")
    public Optional<Profile> getProfile(@PathVariable("profileId") int profileId) {
        return service.getProfile(profileId);
    }

    @PostMapping("/save")
    public Profile save(@RequestBody Profile profile) {
        return service.save(profile);
    }

    @DeleteMapping("/delete/{profileId}")
    public boolean delete(@PathVariable("profileId") int profileId) {
        return service.delete(profileId);
    }

}
