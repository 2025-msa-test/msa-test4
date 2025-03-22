package com.example.msatest4.customer.service;
import com.example.msatest4.customer.entity.Customer;
import com.example.msatest4.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer updateCustomer(Long id, Customer updatedData) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(updatedData.getName());
            customer.setEmail(updatedData.getEmail());
            return customerRepository.save(customer);
        }).orElse(null);
    }
}