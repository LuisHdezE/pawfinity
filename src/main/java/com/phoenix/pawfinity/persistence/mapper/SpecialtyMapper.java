package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Specialty;
import com.phoenix.pawfinity.persistence.entity.Especialidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper {
    @Mappings({
            @Mapping(source = "id", target = "specialtyId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Specialty toSpecialty(Especialidad especialidad);

    List<Specialty> toSpecialties(List<Especialidad> especialidades);

    @InheritInverseConfiguration
    Especialidad toEspecialidad(Specialty specialty);
}
