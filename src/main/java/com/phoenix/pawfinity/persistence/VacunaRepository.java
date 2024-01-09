package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Vaccine;
import com.phoenix.pawfinity.domain.repository.VaccineRepository;
import com.phoenix.pawfinity.persistence.crud.VacunaCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Vacuna;
import com.phoenix.pawfinity.persistence.mapper.VaccineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VacunaRepository implements VaccineRepository {
    @Autowired
    private VacunaCrudRepository vacunaCrudRepository;
    @Autowired
    private VaccineMapper mapper;

    @Override
    public List<Vaccine> getAll() {
        List<Vacuna> vacuna = (List<Vacuna>) vacunaCrudRepository.findAll();
        return mapper.toVaccines(vacuna);
    }

    @Override
    public Optional<Vaccine> getVaccine(int vaccineId) {
        return vacunaCrudRepository.findById(vaccineId).map(vacuna -> mapper.toVaccine(vacuna));
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        Vacuna vacuna = mapper.toVacuna(vaccine);
        return mapper.toVaccine(vacunaCrudRepository.save(vacuna));
    }

    @Override
    public void delete(int vaccineId) {
        vacunaCrudRepository.deleteById(vaccineId);
    }
}
