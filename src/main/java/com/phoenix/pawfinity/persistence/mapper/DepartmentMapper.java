package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Department;
import com.phoenix.pawfinity.persistence.entity.Departamento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mappings({
            @Mapping(source = "id", target = "departmentId"),
            @Mapping(source = "nombre", target = "name"),
    })
    Department toDepartment(Departamento departamento);

    List<Department> toDepartments(List<Departamento> departamentos);

    @InheritInverseConfiguration
    Departamento toDepartamento(Department department);

}
