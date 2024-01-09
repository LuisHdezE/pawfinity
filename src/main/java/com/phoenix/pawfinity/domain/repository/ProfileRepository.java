package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {
    List<Profile> getAll();

    Optional<Profile> getProfile(int profileId);

    Profile save(Profile profile);

    void delete(int profileId);
}
