package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Pet;
import com.phoenix.pawfinity.domain.repository.PetRepository;
import com.phoenix.pawfinity.persistence.crud.MascotaCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Mascota;
import com.phoenix.pawfinity.persistence.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MascotaRepository implements PetRepository {
    @Autowired
    private MascotaCrudRepository mascotaCrudRepository;
    @Autowired
    private PetMapper mapper;

    @Override
    public List<Pet> getAll() {
        List<Mascota> mascotas = (List<Mascota>) mascotaCrudRepository.findAll();
        return mapper.toPets(mascotas);
    }

    @Override
    public Optional<Pet> getPet(int petId) {
        return mascotaCrudRepository.findById(petId).map(mascota -> mapper.toPet(mascota));
    }

    @Override
    public Pet save(Pet pet) {
        Mascota mascota = mapper.toMascota(pet);
        return mapper.toPet(mascotaCrudRepository.save(mascota));
    }

    @Override
    public void delete(int petId) {
        mascotaCrudRepository.deleteById(petId);
    }
}
