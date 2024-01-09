package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Department;
import com.phoenix.pawfinity.domain.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/all")
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/{departmentId}")
    public Optional<Department> getDepartment(@PathVariable("departmentId") int departmentId) {
        return service.getDepartment(departmentId);
    }

    @PostMapping("/save")
    public Department save(@RequestBody Department department) {
        return service.save(department);
    }

    @DeleteMapping("/delete/{departmentId}")
    public boolean delete(@PathVariable("departmentId") int departmentId) {
        return service.delete(departmentId);
    }
}
