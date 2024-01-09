package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Profile;
import com.phoenix.pawfinity.domain.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public List<Profile> getAll(){
        return profileRepository.getAll();
    }

    public Optional<Profile> getProfile(int profileId){
        return profileRepository.getProfile(profileId);
    }

    public Profile save(Profile profile){
        return profileRepository.save(profile);
    }

    public boolean delete(int profileId){
        return getProfile(profileId).map(profile -> {
            profileRepository.delete(profileId);
            return true;
        }).orElse(false);
    }
}
