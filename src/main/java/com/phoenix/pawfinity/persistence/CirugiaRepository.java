package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Surgery;
import com.phoenix.pawfinity.domain.repository.SurgeryRepository;
import com.phoenix.pawfinity.persistence.crud.CirugiaCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Cirugia;
import com.phoenix.pawfinity.persistence.mapper.SurgeryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CirugiaRepository implements SurgeryRepository {
    @Autowired
    private CirugiaCrudRepository cirugiaCrudRepository;
    @Autowired
    private SurgeryMapper mapper;

    @Override
    public List<Surgery> getAll() {
        List<Cirugia> cirugias = (List<Cirugia>) cirugiaCrudRepository.findAll();
        return mapper.toSurgerys(cirugias);
    }

    @Override
    public Optional<Surgery> getSurgery(int surgeryId) {
        return cirugiaCrudRepository.findById(surgeryId).map(cirugia -> mapper.toSurgery(cirugia));
    }

    @Override
    public Surgery save(Surgery surgery) {
        Cirugia cirugia = mapper.toCirugia(surgery);
        return mapper.toSurgery(cirugiaCrudRepository.save(cirugia));
    }

    @Override
    public void delete(int surgeryId) {
        cirugiaCrudRepository.deleteById(surgeryId);
    }
}
