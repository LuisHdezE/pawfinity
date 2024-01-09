package com.phoenix.pawfinity.persistence;

import com.phoenix.pawfinity.domain.Customer;
import com.phoenix.pawfinity.domain.repository.CustomerRepository;
import com.phoenix.pawfinity.persistence.crud.ClienteCrudRepository;
import com.phoenix.pawfinity.persistence.entity.Cliente;
import com.phoenix.pawfinity.persistence.mapper.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements CustomerRepository {
    private ClienteCrudRepository clienteCrudRepository;
    private CustomerMapper mapper;

    @Override
    public List<Customer> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toCustomers(clientes);
    }

    @Override
    public Optional<Customer> getCustomer(int customerId) {
        return clienteCrudRepository.findById(customerId).map(cliente -> mapper.toCustomer(cliente));
    }

    @Override
    public Customer save(Customer customer) {
        Cliente cliente = mapper.toCliente(customer);
        return mapper.toCustomer(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(int customerId) {

        clienteCrudRepository.deleteById(customerId);
    }
}
