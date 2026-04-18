package com.customer.CRM_Backend.service;

import com.customer.CRM_Backend.entity.Customer;
import com.customer.CRM_Backend.entity.CustomerStatus;
import com.customer.CRM_Backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer createCustomer(Customer customer) {
       if (repo.existsByEmail(customer.getEmail())){
           throw new IllegalStateException("Customer with email already exists");
       } else {
          return repo.save(customer);
       }

    }

}
