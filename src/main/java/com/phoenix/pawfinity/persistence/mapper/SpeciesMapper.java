package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Species;
import com.phoenix.pawfinity.persistence.entity.Especie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpeciesMapper {
    @Mappings({
            @Mapping(source = "id", target = "speciesId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Species toSpecie(Especie especie);

    List<Species> toSpecies(List<Especie> especies);

    @InheritInverseConfiguration
    Especie toEspecie(Species species);
}
