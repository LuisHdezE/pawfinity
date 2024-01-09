package com.phoenix.pawfinity.domain.repository;

import com.phoenix.pawfinity.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> getAll();

    Optional<Customer> getCustomer(int customerId);

    Customer save(Customer customer);

    void delete(int id);
}
