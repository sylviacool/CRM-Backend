package com.customer.CRM_Backend.service;

import com.customer.CRM_Backend.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteractionService {

    @Autowired
    private InteractionRepository repo;
}
