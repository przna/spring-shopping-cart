package com.mph.service;

import java.util.List;
import com.mph.entity.Product;


public interface ProductService {
	public void createProduct(Product product);
	public List<Product> getProductList();
	public Product getProduct(Product product);
	public List<Product> updateProduct(Product product);
	public List<Product> deleteProduct(int productID);
	public List<Product> searchByCategory(String category);
	
	
}