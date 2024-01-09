package com.phoenix.pawfinity.persistence.mapper;

import com.phoenix.pawfinity.domain.Product;
import com.phoenix.pawfinity.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "costo", target = "cost"),
            @Mapping(source = "observacion", target = "observation"),
            @Mapping(source = "recomendacion", target = "recommendation"),
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    Producto toProducto(Product product);
}
