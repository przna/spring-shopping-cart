package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.entity.Customer;
import com.mph.dao.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Customer> getCustomerList() {
		
		return customerDao.getCustomerList();
	}

	@Override
	public void createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
		
	}
	

	

	@Override
	public Customer getCustomer(Customer customer) {
		
		return customerDao.getCustomer(customer);
	}
	
	@Override
	public List<Customer> updateCustomer(Customer customer) {
	
		return customerDao.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(customerId);
	}



	
}
	
