package com.phoenix.pawfinity.persistence.crud;

import com.phoenix.pawfinity.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
