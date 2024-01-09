package com.phoenix.pawfinity.persistence.crud;

import com.phoenix.pawfinity.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {
}
