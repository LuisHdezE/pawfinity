package com.phoenix.pawfinity.persistence.crud;

import com.phoenix.pawfinity.persistence.entity.Vacuna;
import org.springframework.data.repository.CrudRepository;

public interface VacunaCrudRepository extends CrudRepository<Vacuna, Integer> {
}
