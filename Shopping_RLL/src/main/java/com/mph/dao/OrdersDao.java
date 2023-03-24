package com.mph.dao;

import java.util.List;

import com.mph.entity.Orders;

public interface OrdersDao {
	
	public void addOrder(Orders order);
	public List<Orders> getOrderList();
	public Orders getOrder(Orders order);
	public List<Orders> updateOrder(Orders order);
	public List<Orders> deleteOrder(int oid);
	public String payOrder(Orders order);
	
	
}