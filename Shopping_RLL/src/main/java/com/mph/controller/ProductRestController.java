package com.mph.controller;

import java.util.List;
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

import com.mph.entity.Product;
import com.mph.service.ProductService;

@RestController
@RequestMapping(value="/Product")

@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "false",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")

public class ProductRestController {
	List<Product> product;
	@Autowired
	ProductService productService;
			
	@GetMapping("/AllProduct")
	
	public  ResponseEntity<List<Product>> allProduct() {
		
		List<Product> li = productService.getProductList();
		System.out.println("product List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(li,HttpStatus.OK);
		
	}

	

	@PostMapping("/Create")
	public Product createProduct(@RequestBody Product product)
	{
		productService.createProduct(product);
		return product;
	}
	
	@GetMapping("/SearchCategory/{category}")
public  ResponseEntity<List<Product>> searchCategory(@PathVariable("category") String category) {
		
		List<Product> li = productService.searchByCategory(category);
		System.out.println("product List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(li,HttpStatus.OK);
		
	}

}
	/*@DeleteMapping("/delete/{id}")
	public  ResponseEntity<List<Product>> deleteEmployee(@PathVariable("id") int emid) {
		
		List<Product> li = employeeService.deleteEmployee(emid);
		System.out.println("Empl List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(li,HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public  ResponseEntity<List<Product>> updateEmployee(@RequestBody Product emp) {
		
		List<Product> li = employeeService.updateEmployee(emp);
		System.out.println("Empl List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(li,HttpStatus.OK);
		
	}
	
}
	*/