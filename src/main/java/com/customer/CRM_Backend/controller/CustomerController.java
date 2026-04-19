package com.customer.CRM_Backend.controller;

import com.customer.CRM_Backend.entity.Customer;
import com.customer.CRM_Backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getCustomerById(id));
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers  = service.getAllCustomer();
       return ResponseEntity.status(HttpStatus.OK).body(customers);
 }


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer customer1 = service.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
    }
    }

