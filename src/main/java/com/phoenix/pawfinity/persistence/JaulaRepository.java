package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Cage;
import com.phoenix.pawfinity.domain.repository.CageRepository;
import com.phoenix.pawfinity.persistence.crud.JaulaCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Jaula;
import com.phoenix.pawfinity.persistence.mapper.CageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JaulaRepository implements CageRepository {
    @Autowired
    private JaulaCrudRepository jaulaCrudRepository;
    @Autowired
    private CageMapper mapper;

    @Override
    public List<Cage> getAll() {
        List<Jaula> jaulas = (List<Jaula>) jaulaCrudRepository.findAll();
        return mapper.toCages(jaulas);
    }

    @Override
    public Optional<Cage> getCage(int cageId) {
        return jaulaCrudRepository.findById(cageId).map(jaula -> mapper.toCage(jaula));
    }

    @Override
    public Cage save(Cage cage) {
        Jaula jaula = mapper.toJaula(cage);
        return mapper.toCage(jaulaCrudRepository.save(jaula));
    }

    @Override
    public void delete(int cageId) {
        jaulaCrudRepository.deleteById(cageId);
    }
}
