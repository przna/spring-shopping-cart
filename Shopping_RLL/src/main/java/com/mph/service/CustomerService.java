package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mph.entity.Customer;



public interface CustomerService {
	public void createCustomer(Customer customer);
	public List<Customer> getCustomerList();
	public Customer getCustomer(Customer customer);
	public List<Customer> updateCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	
	
}
