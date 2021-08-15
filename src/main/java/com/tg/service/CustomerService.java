package com.tg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.entity.CustomerEntity;
import com.tg.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired  
	CustomerRepository customerRepository; 

	public CustomerEntity saveCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> customers = new ArrayList<CustomerEntity>();  
		customerRepository.findAll().
		forEach(customer -> customers.add(customer));  
		return customers;
	}

	public CustomerEntity getCustomerById(long id) {
		return customerRepository.findById(id).get();
	}


}
