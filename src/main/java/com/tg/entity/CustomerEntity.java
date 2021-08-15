package com.tg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {
	@Id
	@Column
	private long cust_id;
	
	@Column
	String cust_name;
	
	@Column
	String cust_email;
	
	@Column
	String cust_phone;
	
	@Column
	String cust_mktng_preference;


}
