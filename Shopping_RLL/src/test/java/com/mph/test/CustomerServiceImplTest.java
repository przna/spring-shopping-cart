package com.mph.test;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.mph.controller.CustomerRestController;
import com.mph.dao.CustomerDao;
import com.mph.entity.Customer;
import com.mph.service.CustomerServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Mock
	CustomerDao customerDao;
	
	@Test
	public void testGetCustomerList() {
		Customer cus = new Customer(101, "Prasanna", "Palanivel","Male", "chandra@gmail.com",null,"04-05-1999","Password");
		List<Customer> customers = new ArrayList<>();
		customers.add(cus);
		when(customerDao.getCustomerList()).thenReturn(customers);
		Assert.assertNotNull(customerService.getCustomerList());
		Assert.assertEquals(1, customerService.getCustomerList().size());

	}
	@Test
	public void getCustomerById() {
		Customer cus = new Customer(101, "Prasanna", "Palanivel","Male", "prasanna@gmail.com",null,"04-05-1999","Password");

		Customer cus1 = new Customer(102, "Balaji", "Palanivel","Male", "balaji@gmail.com",null,"13-05-1997","Password");

		when(customerDao.getCustomerById(101)).thenReturn(cus);
		when(customerDao.getCustomerById(102)).thenReturn(cus1);
		Assert.assertEquals("Prasanna", customerService.getCustomerById(101).getCustomerFirstname());
		Assert.assertEquals("Palanivel", customerService.getCustomerById(102).getCustomerLastname());

	}
}