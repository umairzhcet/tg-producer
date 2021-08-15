package com.tg.repo;

import org.springframework.data.repository.CrudRepository;

import com.tg.entity.CustomerEntity;

public interface CustomerRepository  extends CrudRepository<CustomerEntity, Long>  {
    	
}