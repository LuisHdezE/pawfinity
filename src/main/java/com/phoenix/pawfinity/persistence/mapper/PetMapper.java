package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Pet;
import com.phoenix.pawfinity.persistence.entity.Mascota;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BreedMapper.class})
public interface PetMapper {
    @Mappings({
            @Mapping(source = "id", target = "petId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "sexo", target = "gender"),
            @Mapping(source = "idRaza", target = "breedId"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "peso", target = "weight"),
            @Mapping(source = "foto", target = "photo"),
            @Mapping(source = "fechaIngreso", target = "admissionDate"),
            @Mapping(source = "fechaEgreso", target = "dischargeDate"),
            @Mapping(source = "adoptado", target = "adopted"),
            @Mapping(source = "raza", target = "breed"),
    })
    Pet toPet(Mascota mascota);

    List<Pet> toPets(List<Mascota> mascotas);

    @InheritInverseConfiguration
    Mascota toMascota(Pet pet);
}
