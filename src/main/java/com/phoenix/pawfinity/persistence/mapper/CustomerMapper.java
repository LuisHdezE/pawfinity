package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Customer;
import com.phoenix.pawfinity.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface CustomerMapper {
    @Mappings({
            @Mapping(source = "id", target = "customerId"),
            @Mapping(source = "cedula", target = "identification"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "secondName"),
            @Mapping(source = "sapellidos", target = "thirdName"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "idDepartamento", target = "departmentId"),
            @Mapping(source = "departamento", target = "department"),
    })
    Customer toCustomer(Cliente cliente);

    List<Customer> toCustomers(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Customer customer);
}
