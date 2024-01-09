package com.phoenix.pawfinity.persistence.crud;

import com.phoenix.pawfinity.persistence.entity.Mascota;
import org.springframework.data.repository.CrudRepository;

public interface MascotaCrudRepository extends CrudRepository<Mascota, Integer> {
}
