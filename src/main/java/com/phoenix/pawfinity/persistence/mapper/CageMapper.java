package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Cage;
import com.phoenix.pawfinity.persistence.entity.Jaula;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CageMapper {
    @Mappings({
            @Mapping(source = "id",target = "cageId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "disponible",target = "available"),
    })
    Cage toCage(Jaula jaula);
    List<Cage> toCages(List<Jaula> jaulas);
    @InheritInverseConfiguration
    Jaula toJaula(Cage cage);
}
