package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Profile;
import com.phoenix.pawfinity.persistence.entity.Perfil;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mappings({
            @Mapping(source = "id", target = "profileId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "observacion", target = "observation"),
    })
    Profile toProfile(Perfil perfil);

    List<Profile> toProfiles(List<Perfil> perfils);

    @InheritInverseConfiguration
    Perfil toPerfil(Profile profile);
}
