package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Treatment;
import com.phoenix.pawfinity.persistence.entity.Tratamiento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TreatmentMapper {
    @Mappings({
            @Mapping(source = "id", target = "treatmentId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "recomendacion", target = "recommendation"),
    })
    Treatment toTreatment(Tratamiento tratamiento);

    List<Treatment> toTreatments(List<Tratamiento> tratamientos);

    @InheritInverseConfiguration
    Tratamiento toTratamiento(Treatment treatment);
}
