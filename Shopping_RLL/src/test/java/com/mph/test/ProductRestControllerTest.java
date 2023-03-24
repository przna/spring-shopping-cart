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
import com.mph.controller.ProductRestController;
import com.mph.entity.Customer;
import com.mph.entity.Product;
import com.mph.service.CustomerServiceImpl;
import com.mph.service.ProductServiceImpl;

import junit.framework.Assert;
/**
 * 
 * @author Prasanna_Palanivel
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class ProductRestControllerTest {

	@InjectMocks
	ProductRestController productRestController;
	
	@Mock
	ProductServiceImpl productService;
	
	@Test
	public void testAllProduct() {
		Product product = new Product();
		List<Product> products = new ArrayList<>();
		products.add(product);
		Assert.assertNotNull(productRestController.allProduct());
		Assert.assertEquals(204, productRestController.allProduct().getStatusCodeValue());
		when(productService.getProductList()).thenReturn(products);
		Assert.assertNotNull(productRestController.allProduct());
		Assert.assertEquals(1, productRestController.allProduct().getBody().size());

	}

}