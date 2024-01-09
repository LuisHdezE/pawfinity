package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Breed;
import com.phoenix.pawfinity.persistence.entity.Raza;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BreedMapper {
    @Mappings({
            @Mapping(source = "id", target = "breedId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "idEspecie", target = "speciesId"),
            @Mapping(source = "especie", target = "species"),
    })
    Breed toBreed(Raza raza);
    List<Breed> toBreeds(List<Raza> razas);
    @InheritInverseConfiguration
    Raza toRaza(Breed breed);
}
