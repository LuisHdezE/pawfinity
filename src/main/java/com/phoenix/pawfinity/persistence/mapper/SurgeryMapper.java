package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Surgery;
import com.phoenix.pawfinity.persistence.entity.Cirugia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SurgeryMapper {
    @Mappings({
            @Mapping(source = "id", target = "surgeryId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "observacion", target = "observation"),
            @Mapping(source = "recomendacion", target = "recommendation"),
    })
    Surgery toSurgery(Cirugia cirugia);

    List<Surgery> toSurgerys(List<Cirugia> cirugias);

    @InheritInverseConfiguration
    Cirugia toCirugia(Surgery surgery);
}
