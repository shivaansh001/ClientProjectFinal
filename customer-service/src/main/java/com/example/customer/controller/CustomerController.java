package com.example.customer.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository repo;

	
	
	@GetMapping(path="/customers")
	public List<Customer>getAllItems(){
		return (List<Customer>)repo.findAll();
	}
	
	@GetMapping("/check/customer/{custId}")
	public boolean checkCustomer(@PathVariable("custId") int custId) {
		 System.out.println(customerService.checkCustomer(custId));
		 Optional<Customer> c1=customerService.checkCustomer(custId);
		 if(c1.isEmpty()) {
			 return false;
		 }
		 return true;
	}
	@PostMapping(path="/customer")
	public String add(@RequestBody Customer customer) {
		repo.save(customer);
		return "Data saved";
	}
	
}
