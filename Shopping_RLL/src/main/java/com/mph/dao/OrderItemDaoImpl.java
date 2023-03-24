package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.OrderItem;

@Repository
public class OrderItemDaoImpl implements OrderItemDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public OrderItemDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrderItem> addProduct2Cart(int id) {
		Query query = getSession().createQuery(
				"INSERT INTO OrderItem(productName,unitPrice,imageUrl) SELECT p.productName,p.productPrice,p.imageUrl FROM Product p WHERE id =:id");
		query.setParameter("id", id);
		
		
	//	List<OrderItem> cartList = query.list();
	

		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Inserted " + noofrows + "rows. ");
		}
		return getCartList();

	}

	@Override
	public List<OrderItem> deleteProductFromCart(int pid) {
		Query query = getSession().createQuery("delete OrderItem pc where pid =:pid");
		query.setParameter("pid", pid);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getCartList();
	}

	@Override
	public List<OrderItem> getCartList() {
		Query query = getSession().createQuery("select me from OrderItem me");
		List<OrderItem> productList = query.list();
		return productList;
	}
	@Override
	public int getNumberofRowsInCart() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("select count(*) from OrderItem me");
		int count =(int) query.uniqueResult();
		return count;
	}
}
