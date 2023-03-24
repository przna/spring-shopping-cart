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

import com.mph.entity.Orders;
import com.mph.service.OrdersService;

@RestController
@RequestMapping("/Orders")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class OrdersRestController {

	@Autowired
	OrdersService orderService;

	private static final Logger logger = Logger.getLogger("OrderRestController.class");

	@GetMapping("/AllOrders")
	public ResponseEntity<List<Orders>> allOrder() {
		logger.info("GETTING REQUEST FROM CLIENT TO SHOW THE ORDER DETAILS");
		System.out.println(logger.getName() + "   " + logger.getLevel());

		PropertyConfigurator.configure(OrdersRestController.class.getClassLoader().getResource("log4j.properties"));
		logger.info("Log4j appender configuration is successfull !!!!");
		List<Orders> li = orderService.getOrderList();
		System.out.println("Ord List : " + li);

		if (li.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(li, HttpStatus.OK);

	}

	@PostMapping("/Add")
	public Orders addOrder(@RequestBody Orders order) {
		orderService.addOrder(order);
		return order;
	}

	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<List<Orders>> deleteOrder(@PathVariable("id") int oid) {

		List<Orders> li = orderService.deleteOrder(oid);
		System.out.println("Ord List : " + li);

		if (li.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(li, HttpStatus.OK);

	}

	@PutMapping("/Update")
	public ResponseEntity<List<Orders>> updateOrder(@RequestBody Orders ord) {

		List<Orders> li = orderService.updateOrder(ord);
		System.out.println("Ord List : " + li);

		if (li.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(li, HttpStatus.OK);

	}

	@PutMapping("/Pay")
	public ResponseEntity<List<Orders>> payOrder(@RequestBody Orders ord) {

		String li = orderService.payOrder(ord);
		

		if (li.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(HttpStatus.OK);

	}

}