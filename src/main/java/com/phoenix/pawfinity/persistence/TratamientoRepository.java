package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Treatment;
import com.phoenix.pawfinity.domain.repository.TreatmentRepository;
import com.phoenix.pawfinity.persistence.crud.TratamientoCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Tratamiento;
import com.phoenix.pawfinity.persistence.mapper.TreatmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TratamientoRepository implements TreatmentRepository {
    @Autowired
    private TratamientoCrudRepository tratamientoCrudRepository;
    @Autowired
    private TreatmentMapper mapper;

    @Override
    public List<Treatment> getAll() {
        List<Tratamiento> tratamientos = (List<Tratamiento>) tratamientoCrudRepository.findAll();
        return mapper.toTreatments(tratamientos);
    }

    @Override
    public Optional<Treatment> getTreatment(int treatmentId) {
        return tratamientoCrudRepository.findById(treatmentId).map(tratamiento -> mapper.toTreatment(tratamiento));
    }

    @Override
    public Treatment save(Treatment treatment) {
        Tratamiento tratamiento = mapper.toTratamiento(treatment);
        return mapper.toTreatment(tratamientoCrudRepository.save(tratamiento));
    }

    @Override
    public void delete(int treatmentId) {
        tratamientoCrudRepository.deleteById(treatmentId);

    }
}
