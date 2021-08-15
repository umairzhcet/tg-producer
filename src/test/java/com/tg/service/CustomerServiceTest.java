package com.tg.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.tg.entity.CustomerEntity;
import com.tg.repo.CustomerRepository;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepository customerRepository;

	@SuppressWarnings("deprecation")
	@Test
	void testFindAllCustomers() {
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		CustomerEntity c2=new CustomerEntity(2,"cus2","xyz@gmail.com","12346","phone");
		ArrayList<CustomerEntity> list=new ArrayList<>();
		list.add(c1);
		list.add(c2);
		when(customerRepository.findAll()).thenReturn(list);
		List<CustomerEntity> response=customerService.getAllCustomers();
		Assert.notNull(response);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testFindCustomerById() {
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		when(customerRepository.findById(1L)).thenReturn(Optional.of(c1));
		CustomerEntity customer=customerService.getCustomerById(1L);
		Assert.notNull(customer);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testSaveCustomer() {
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		when(customerRepository.save(c1)).thenReturn(c1);
		CustomerEntity cust=customerService.saveCustomer(c1);
		Assert.isTrue(c1.getCust_id()==cust.getCust_id());
	}

}
