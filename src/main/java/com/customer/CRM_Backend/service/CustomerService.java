package com.customer.CRM_Backend.service;

import com.customer.CRM_Backend.entity.Customer;
import com.customer.CRM_Backend.exception.ResourceNotFoundException;
import com.customer.CRM_Backend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repo;

    public Customer createCustomer(Customer customer) {
       if (repo.existsByEmail(customer.getEmail())){
           throw new IllegalStateException("Customer with email already exists");
       } else {
          return repo.save(customer);
       }

    }

    public List<Customer> getAllCustomers() {

        return repo.findAll();
    }


    public Customer getCustomerById(long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    public Customer updateCustomer(long id, Customer customer) {
        Customer customer1 = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        //updating
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setEmail(customer.getEmail());

        //save updated customer
        return repo.save(customer1);
    }

    public void deleteCustomer(long id) {
        Customer customer = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        repo.deleteById(id);
    }

    // public String deleteCustomer(long id) {
    //        Optional<Customer> optional = repo.findById(id);
    //        if (optional.isPresent()) {
    //             repo.deleteById(id);
    //           return "Customer deleted successfully for id: "+id;
    //        }
    //        throw new ResourceNotFoundException("Customer not found with id: " + id);
    //    }


}
