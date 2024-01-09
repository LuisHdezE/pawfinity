package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Section;
import com.phoenix.pawfinity.domain.repository.SectionRepository;
import com.phoenix.pawfinity.persistence.crud.AreaCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Area;
import com.phoenix.pawfinity.persistence.mapper.SectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AreaRepository implements SectionRepository {
    @Autowired
    private AreaCrudRepository areaCrudRepository;
    @Autowired
    private SectionMapper mapper;

    @Override
    public List<Section> getAll() {
        List<Area> areas=(List<Area>) areaCrudRepository.findAll();
        return mapper.toSections(areas);
    }

    @Override
    public Optional<Section> getSection(int sectionId) {
        return areaCrudRepository.findById(sectionId).map(area-> mapper.toSection(area));
    }

    @Override
    public Section save(Section section) {
        Area area= mapper.toArea(section);
        return mapper.toSection(areaCrudRepository.save(area));
    }

    @Override
    public void delete(int sectionId) {
        areaCrudRepository.deleteById(sectionId);
    }
}
