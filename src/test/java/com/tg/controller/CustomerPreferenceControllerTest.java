package com.tg.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tg.entity.CustomerEntity;
import com.tg.service.CustomerService;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerPreferenceControllerTest {
	
	@MockBean
	private CustomerService customerService;
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	void testGetAllCustomers() throws Exception {
		
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		CustomerEntity c2=new CustomerEntity(2,"cus2","xyz@gmail.com","12346","phone");
		ArrayList<CustomerEntity> list=new ArrayList<>();
		list.add(c1);
		list.add(c2);
		when(customerService.getAllCustomers()).thenReturn(list);
		mockMvc.perform(get("/customer"))
        // Validate the response code and content type
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))

         // Validate the returned fields
        .andExpect(jsonPath("$[0].cust_id", is(1)))
        .andExpect(jsonPath("$[1].cust_id", is(2)));
	}
	
	@Test
	void testGetCustomerById() throws Exception {
		
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		when(customerService.getCustomerById(1)).thenReturn(c1);
		mockMvc.perform(get("/customer/{id}",1L))
         // Validate the response code and content type
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))

         // Validate the returned fields
        .andExpect(jsonPath("$.cust_id", is(1)));
         
	}
	
	@Test
	void testSaveCustomer() throws Exception {
		
		CustomerEntity c1=new CustomerEntity(1,"cus1","abc@gmail.com","12345","sms");
		when(customerService.saveCustomer(c1)).thenReturn(c1);
		mockMvc.perform(post("/customer")
		.contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(c1)))

         // Validate the response code and content type
        .andExpect(status().isOk());
         
	}
	
	 static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }	

}
