package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Section;

import java.util.List;
import java.util.Optional;

public interface SectionRepository {
    List<Section> getAll();

    Optional<Section> getSection(int sectionId);

    Section save(Section section);

    void delete(int sectionId);
}
