package com.phoenix.pawfinity.domain.service;

import com.phoenix.pawfinity.domain.Customer;
import com.phoenix.pawfinity.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public Optional<Customer> getCustomer(int customerId) {
        return customerRepository.getCustomer(customerId);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean delete(int id) {
        return getCustomer(id).map(customer -> {
            customerRepository.delete(id);
            return true;
        }).orElse(false);
    }

}
