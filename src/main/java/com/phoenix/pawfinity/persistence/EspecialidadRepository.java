package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Specialty;
import com.phoenix.pawfinity.domain.repository.SpecialtyRepository;
import com.phoenix.pawfinity.persistence.crud.EspecialidadCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Especialidad;
import com.phoenix.pawfinity.persistence.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EspecialidadRepository implements SpecialtyRepository {
    @Autowired
    private EspecialidadCrudRepository especialidadCrudRepository;
    @Autowired
    private SpecialtyMapper mapper;

    @Override
    public List<Specialty> getAll() {
        List<Especialidad> especialidades = (List<Especialidad>) especialidadCrudRepository.findAll();
        return mapper.toSpecialties(especialidades);
    }

    @Override
    public Optional<Specialty> getSpecialty(int specialtyId) {
        return especialidadCrudRepository.findById(specialtyId).map(especialidad -> mapper.toSpecialty(especialidad));
    }

    @Override
    public Specialty save(Specialty specialty) {
        Especialidad especialidad=mapper.toEspecialidad(specialty);
        return mapper.toSpecialty(especialidadCrudRepository.save(especialidad));
    }

    @Override
    public void delete(int specialtyId) {
        especialidadCrudRepository.deleteById(specialtyId);
    }
}
