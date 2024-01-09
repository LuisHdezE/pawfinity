package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Department;
import com.phoenix.pawfinity.domain.repository.DepartmentRepository;
import com.phoenix.pawfinity.persistence.crud.DepartamentoCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Departamento;
import com.phoenix.pawfinity.persistence.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartamentoRepository implements DepartmentRepository {
    @Autowired
    private DepartamentoCrudRepository departamentoCrudRepository;
    @Autowired
    private DepartmentMapper mapper;

    @Override
    public List<Department> getAll() {
        List<Departamento> departamentos = (List<Departamento>) departamentoCrudRepository.findAll();
        return mapper.toDepartments(departamentos);
    }

    @Override
    public Optional<Department> getDepartment(int departmentId) {
        return departamentoCrudRepository.findById(departmentId).map(departamento -> mapper.toDepartment(departamento));
    }

    @Override
    public Department save(Department department) {
        Departamento departamento = mapper.toDepartamento(department);
        return mapper.toDepartment(departamentoCrudRepository.save(departamento));
    }

    @Override
    public void delete(int departmentId) {
        departamentoCrudRepository.deleteById(departmentId);
    }

}
