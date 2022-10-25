package com.example.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
    private CustomerRepository repo;
     
    
     
	public Optional<Customer> checkCustomer(int custId) {
		return repo.findById(custId);
	}
}
