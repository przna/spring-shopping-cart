package com.mph.controller;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.LogManager;
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

import com.mph.entity.OrderItem;
import com.mph.service.OrderItemService;

@RestController
@RequestMapping(value = "/OrderItem")

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class OrderItemRestController {
	@Autowired
	OrderItemService orderItemService;
	private static final Logger logger = LogManager.getLogger("OrderItemRestController.class");

	@GetMapping("/AllCart")
	private ResponseEntity<List<OrderItem>> allOrderItem() {
		logger.info("GETTING REQUEST FROM CLIENT TO SHOW THE LIST OF CART ORDER ITEMS");
		System.out.println(logger.getName()+"   "+ logger.getLevel());
		
		
		PropertyConfigurator.configure(OrderItemRestController.class.getClassLoader().getResource("log4j.properties"));
		logger.info("Log4j appender configuration is successfull !!!!");
		List<OrderItem> li = orderItemService.getCartList();
		if (li.isEmpty()) {
			return new ResponseEntity<List<OrderItem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderItem>>(li, HttpStatus.OK);
	}
	
	@GetMapping("/Add2Cart/{id}")
	public  ResponseEntity<List<OrderItem>> add2Cart(@PathVariable("id") int id) {
		
		List<OrderItem> li = orderItemService.addProduct2Cart(id);
		
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<OrderItem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderItem>>(li, HttpStatus.OK);
	}
	@DeleteMapping("/Delete/{id}")
	public  ResponseEntity<List<OrderItem>> deleteFromCart(@PathVariable("id") int emid) {
		
		List<OrderItem> li = orderItemService.deleteProductFromCart(emid);
		System.out.println("Cart List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<OrderItem>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderItem>>(li,HttpStatus.OK);
		
	}

}
