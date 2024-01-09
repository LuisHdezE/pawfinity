package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Section;
import com.phoenix.pawfinity.persistence.entity.Area;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    @Mappings({
            @Mapping(source = "id", target = "sectionId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "telefono", target = "phone"),
    })
    Section toSection(Area area);
    List<Section> toSections(List<Area> areas);

    @InheritInverseConfiguration
    Area toArea(Section section);
}
