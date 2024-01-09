package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Section;
import com.phoenix.pawfinity.domain.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    public List<Section> getAll(){
        return sectionRepository.getAll();
    }

    public Optional<Section> getSection(int sectionId){
        return sectionRepository.getSection(sectionId);
    }

    public Section save(Section section){
        return sectionRepository.save(section);
    }

    public boolean delete(int sectionId){
        return getSection(sectionId).map(section -> {
            sectionRepository.delete(sectionId);
            return true;
        }).orElse(false);
    }
}
