package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.OrdersDao;
import com.mph.entity.Orders;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{

	
	@Autowired
	OrdersDao orderDao;
	
	@Override
	public void addOrder(Orders order) {
		orderDao.addOrder(order);
		
	}

	@Override
	public List<Orders> getOrderList() {
		
		return orderDao.getOrderList();
	}

	@Override
	public Orders getOrder(Orders order) {
		
		return orderDao.getOrder(order);
	}
	
	@Override
	public List<Orders> updateOrder(Orders order) {
	
		return orderDao.updateOrder(order);
	}

	@Override
	public List<Orders> deleteOrder(int oid) {
		
		return orderDao.deleteOrder(oid);
	}

	
	@Override
	public String payOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDao.payOrder(order);
	}	
}