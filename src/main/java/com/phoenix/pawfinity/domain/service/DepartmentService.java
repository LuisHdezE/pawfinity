package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Department;
import com.phoenix.pawfinity.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.getAll();
    }

    public Optional<Department> getDepartment(int departmentId) {
        return departmentRepository.getDepartment(departmentId);
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public boolean delete(int departmentId) {
        return getDepartment(departmentId).map(department -> {
            departmentRepository.delete(departmentId);
            return true;
        }).orElse(false);
    }

}
