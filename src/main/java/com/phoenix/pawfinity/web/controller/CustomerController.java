package com.phoenix.pawfinity.web.controller;

import com.phoenix.pawfinity.domain.Customer;
import com.phoenix.pawfinity.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/all")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable("customerId") int customerId) {
        return service.getCustomer(customerId);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public boolean delete(@PathVariable("customerId") int id) {
        return service.delete(id);
    }

}
