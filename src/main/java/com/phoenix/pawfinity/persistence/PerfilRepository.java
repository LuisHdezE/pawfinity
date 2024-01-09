package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Profile;
import com.phoenix.pawfinity.domain.repository.ProfileRepository;
import com.phoenix.pawfinity.persistence.crud.PerfilCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Perfil;
import com.phoenix.pawfinity.persistence.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PerfilRepository implements ProfileRepository {
    @Autowired
    private PerfilCrudRepository perfilCrudRepository;
    @Autowired
    private ProfileMapper mapper;

    @Override
    public List<Profile> getAll() {
        List<Perfil> perfiles = (List<Perfil>) perfilCrudRepository.findAll();
        return mapper.toProfiles(perfiles);
    }

    @Override
    public Optional<Profile> getProfile(int profileId) {
        return perfilCrudRepository.findById(profileId).map(perfil -> mapper.toProfile(perfil));
    }

    @Override
    public Profile save(Profile profile) {
        Perfil perfil = mapper.toPerfil(profile);
        return mapper.toProfile(perfilCrudRepository.save(perfil));
    }

    @Override
    public void delete(int profileId) {
        perfilCrudRepository.deleteById(profileId);
    }
}
