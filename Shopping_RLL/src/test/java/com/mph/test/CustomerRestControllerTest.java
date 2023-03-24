package com.mph.test;
/**
 * 
 * @author Prasanna_Palanivel
 *
 */
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
import com.mph.entity.Customer;
import com.mph.service.CustomerServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class CustomerRestControllerTest {

	@InjectMocks
	CustomerRestController customerRestController;
	
	@Mock
	CustomerServiceImpl customerService;
	
	@Test
	public void testAllCustomer() {
		Customer cust = new Customer();
		List<Customer> customer = new ArrayList<>();
		customer.add(cust);
		Assert.assertNotNull(customerRestController.allCustomer());
		Assert.assertEquals(204, customerRestController.allCustomer().getStatusCodeValue());
		when(customerService.getCustomerList()).thenReturn(customer);
		Assert.assertNotNull(customerRestController.allCustomer());
		Assert.assertEquals(1, customerRestController.allCustomer().getBody().size());

	}

}