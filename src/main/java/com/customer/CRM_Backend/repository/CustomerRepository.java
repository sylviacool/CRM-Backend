package com.customer.CRM_Backend.repository;

import com.customer.CRM_Backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   //Customer findByEmail(String email);
   boolean existsByEmail(String email);
}

