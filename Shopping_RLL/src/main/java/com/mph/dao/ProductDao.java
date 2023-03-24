package com.mph.dao;

import java.util.List;

import com.mph.entity.Product;

public interface ProductDao {
	public void createProduct(Product product);
	public List<Product> getProductList();
	public Product getProduct(Product product);
	//public List<Product> addProduct2Cart(int productID);
//	public List<Product> removeProductFromCart(int productID);
	public List<Product> updateProduct(Product product);
	public List<Product> deleteProduct(int productID);
	public List<Product> searchByCategory(String category);
	
}
