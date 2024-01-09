package com.phoenix.pawfinity.persistence.crud;

import com.phoenix.pawfinity.persistence.entity.Especie;
import org.springframework.data.repository.CrudRepository;

public interface EspecieCrudRepository extends CrudRepository<Especie, Integer> {
}
