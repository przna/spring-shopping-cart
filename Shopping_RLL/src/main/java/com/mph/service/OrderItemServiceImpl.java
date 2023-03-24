package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.OrderItemDao;
import com.mph.entity.OrderItem;
@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	OrderItemDao orderItemDao ;
	public OrderItemServiceImpl() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public List<OrderItem> getCartList() {
		// TODO Auto-generated method stub
		return orderItemDao.getCartList();
	}

	@Override
	public List<OrderItem> addProduct2Cart(int pid) {
		// TODO Auto-generated method stub
		return orderItemDao.addProduct2Cart(pid);
	}

	@Override
	public List<OrderItem> deleteProductFromCart(int pid) {
		// TODO Auto-generated method stub
		return orderItemDao.deleteProductFromCart(pid);
	}

	@Override
	public int getNumberofRowsInCart() {
		// TODO Auto-generated method stub
		return orderItemDao.getNumberofRowsInCart();
	}

}
