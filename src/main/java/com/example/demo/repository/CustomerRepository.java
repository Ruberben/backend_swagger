package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    // Save or create a new customer
    public Customer save(Customer customer) {
        customer.setId((long) (customers.size() + 1));
        customers.add(customer);
        return customer;
    }

    // Get all customers
    public List<Customer> findAll() {
        return customers;
    }

    // Find customer by ID
    public Optional<Customer> findById(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    // Get customer's balance by ID
    public Optional<Double> getBalanceById(Long id) {
        return findById(id).map(Customer::getBalance);
    }
}
