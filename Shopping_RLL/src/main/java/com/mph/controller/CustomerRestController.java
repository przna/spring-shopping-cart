package com.mph.controller;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Customer;
import com.mph.service.CustomerService;


@RestController
@RequestMapping(value="/Customer")

@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = { RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;
	
	private static final Logger logger = Logger.getLogger("CustomerRestController.class");
	
	
	@GetMapping("/AllCustomer")
	public  ResponseEntity<List<Customer>> allCustomer() {
		logger.info("GETTING REQUEST  TO SHOW THE LIST OF CUSTOMER");
		System.out.println(logger.getName()+"   "+ logger.getLevel());
		
		
		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		logger.info("Log4j appender configuration is successfull !!!!");
		List<Customer> li = customerService.getCustomerList();
		System.out.println("Customer List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
		
	}
	
	@PostMapping("/Register")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		customerService.createCustomer(customer);
		return customer;
	}
	
	
	@PutMapping("/Update")
	public  ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {
		
		List<Customer> li = customerService.updateCustomer(customer);
		System.out.println("Customer List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(li,HttpStatus.OK);
		
	}
	
}