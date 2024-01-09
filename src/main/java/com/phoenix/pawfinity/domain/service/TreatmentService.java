package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Treatment;
import com.phoenix.pawfinity.domain.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;
   public List<Treatment> getAll(){
       return treatmentRepository.getAll();
   }

    public Optional<Treatment> getTreatment(int treatmentId){
       return treatmentRepository.getTreatment(treatmentId);
    }

    public Treatment save(Treatment treatment){
       return treatmentRepository.save(treatment);
    }

    public boolean delete(int treatmentId){
       return getTreatment(treatmentId).map(treatment -> {
           treatmentRepository.delete(treatmentId);
           return true;
       }).orElse(false);
    }
}
