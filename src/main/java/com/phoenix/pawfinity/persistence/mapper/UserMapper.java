package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.User;
import com.phoenix.pawfinity.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, SectionMapper.class, SpecialtyMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "secondName"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "idPerfil", target = "profileId"),
            @Mapping(source = "idArea", target = "sectionId"),
            @Mapping(source = "idEspecialidad", target = "specialtyId"),
            @Mapping(source = "foto", target = "photo"),
            @Mapping(source = "contrasenia", target = "password"),
            @Mapping(source = "perfil", target = "profile"),
            @Mapping(source = "area", target = "section"),
            @Mapping(source = "especialidad", target = "specialty"),
    })
    User toUser(Usuario usuario);

    List<User> toUsers(List<Usuario> usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);

}
