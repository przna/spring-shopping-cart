package com.mph.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createProduct(Product product) {
		getSession().saveOrUpdate(product);
		System.out.println("Product Stored in DB Successfully !!!");
	}

	@Override
	public List<Product> getProductList() {
		Query query = getSession().createQuery("select me from Product me");
		List<Product> prodList = query.list();
		return prodList;
	}

	@Override
	public Product getProduct(Product product) {
		Criteria c = getSession().createCriteria(Product.class);
		c.add(Restrictions.eq("productId", product.getProductId()));
		Product prod = (Product) c.uniqueResult();
		return prod;
		
	}


	@Override
	public List<Product> updateProduct(Product product) {
		Query query = getSession().createQuery("update Product me set productName=:name,productPrice=:unit_price,imageUrl=:image_url,category=:category where productId =:id");
		query.setParameter("name",product.getProductName());
		query.setParameter("description",product.getCategory());
		query.setParameter("unit_price",product.getProductPrice());
		query.setParameter("image_url",product.getImageUrl());
		query.setParameter("category",product.getCategory());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getProductList();
	}


	@Override
	public List<Product> deleteProduct(int productID) {
		Query query = getSession().createQuery("delete Product me where productId =:id");
		query.setParameter("id", productID);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getProductList();
	}
	/*
	List<Product> productCart = new ArrayList<Product>(); 
	
	@Override
	public List<Product> addProduct2Cart(int productID) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("select me from product me where id=:id");
		query.setParameter("id", productID);
		List<Product> productCart = query.list();

		return productCart;
	}

	@Override
	public List<Product> removeProductFromCart(int productID) {
		// TODO Auto-generated method stub
		productCart.remove(productID);
		return productCart;
	}
*/
	@Override
	public List<Product> searchByCategory(String category) {
		Query query = getSession().createQuery("select me from Product me where category=:category");
		query.setParameter("category", category);
		List<Product> productCategoryList = query.list();
		System.out.println(productCategoryList);
		return productCategoryList;
	}
}
	
