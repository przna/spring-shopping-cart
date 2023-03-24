package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.mph.entity.Orders;


public interface OrdersService {
	public void addOrder(Orders order);
	public List<Orders> getOrderList();
	public Orders getOrder(Orders order);
	public List<Orders> updateOrder(Orders order);
	public List<Orders> deleteOrder(int oid);
	public String payOrder(Orders order);

}