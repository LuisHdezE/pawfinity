package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Vaccine;
import com.phoenix.pawfinity.persistence.entity.Vacuna;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccineMapper {
    @Mappings({
            @Mapping(source = "id", target = "vaccineId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "observacion", target = "observation"),
            @Mapping(source = "recomendacion", target = "recommendation"),
            @Mapping(source = "costo", target = "cost"),
    })
    Vaccine toVaccine(Vacuna vacuna);

    List<Vaccine> toVaccines(List<Vacuna> vacuna);

    @InheritInverseConfiguration
    Vacuna toVacuna(Vaccine vaccine);

}
