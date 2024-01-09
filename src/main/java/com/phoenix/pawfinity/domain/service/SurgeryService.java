package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Surgery;
import com.phoenix.pawfinity.domain.repository.SurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;
    public List<Surgery> getAll(){
        return surgeryRepository.getAll();
    }

    public Optional<Surgery> getSurgery(int surgeryId){
        return surgeryRepository.getSurgery(surgeryId);
    }

    public Surgery save(Surgery surgery){
        return surgeryRepository.save(surgery);
    }

    public boolean delete(int surgeryId){
        return getSurgery(surgeryId).map(surgery -> {
            surgeryRepository.delete(surgeryId);
            return true;
        }).orElse(false);
    }

}
