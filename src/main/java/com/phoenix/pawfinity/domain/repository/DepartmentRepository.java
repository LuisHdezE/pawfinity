package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    List<Department> getAll();

    Optional<Department> getDepartment(int departmentId);

    Department save(Department department);

    void delete(int departmentId);
}
