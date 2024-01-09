package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Surgery;

import java.util.List;
import java.util.Optional;

public interface SurgeryRepository {
    List<Surgery> getAll();

    Optional<Surgery> getSurgery(int surgeryId);

    Surgery save(Surgery surgery);

    void delete(int surgeryId);
}
