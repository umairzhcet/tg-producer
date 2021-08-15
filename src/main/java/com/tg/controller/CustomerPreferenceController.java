package com.tg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tg.entity.CustomerEntity;
import com.tg.service.CustomerService;

@RestController
public class CustomerPreferenceController {
	
	@Autowired
	CustomerService customerService; 
	
	@PostMapping("/customer")  
	private CustomerEntity saveStudent(@RequestBody CustomerEntity customer)   
	{  
	return customerService.saveCustomer(customer);
	}  
	
	@GetMapping("/customer")  
	private List<CustomerEntity> getAllCustomers()   
	{  
	return customerService.getAllCustomers();  
	}
	
	@GetMapping("/customer/{id}")  
	private CustomerEntity getCustomer(@PathVariable("id") int id)   
	{  
	return customerService.getCustomerById(id);  
	}  

}
