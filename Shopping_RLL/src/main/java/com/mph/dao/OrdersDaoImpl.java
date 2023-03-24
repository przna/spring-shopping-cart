package com.mph.dao;

import java.util.UUID;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Orders;


public class OrdersDaoImpl implements OrdersDao {

	public OrdersDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	 

		@Autowired
		private SessionFactory sessionFactory;

		protected Session getSession() {
			return sessionFactory.getCurrentSession();
		}
		
		/**
		   * This method is used to insert employees in database. 
		   * @param employee This is the first paramter to createEmployee method
		   * 
		   * @return void This will not return anything
		   */

		@Override
		public void addOrder(Orders order) {
			getSession().saveOrUpdate(order);
			System.out.println("Order Stored in DB Successfully !!!");
		}

		
		@Override
		public List<Orders> getOrderList() {
			Query query = getSession().createQuery("select me from Orders me");
			List<Orders> ordList = query.list();
			return ordList;
		}

		@Override
		public Orders getOrder(Orders order) {
			Criteria c = getSession().createCriteria(Orders.class);
			c.add(Restrictions.eq("orderid", order.getOrderID()));
			Orders  ord = (Orders ) c.uniqueResult();
			return ord;
		}

		
		@Override
		public List<Orders> updateOrder(Orders order) {
			Query query = getSession().createQuery("update Orders me set totalPrice=:totalPrice,address=:address where orderID =:id");
			
			query.setParameter("totalPrice",order.getTotalPrice());
			query.setParameter("address",order.getAddress());
			query.setParameter("id",order.getOrderID());
			
			
			
			int noofrows = query.executeUpdate();
			if (noofrows > 0) {
				System.out.println("Updated " + noofrows + "rows. ");
			}
			return getOrderList();
		}

		@Override
		public List<Orders> deleteOrder(int oid) {
			Query query = getSession().createQuery("delete Orders me where orderID =:oid");
			query.setParameter("oid", oid);
			int noofrows = query.executeUpdate();
			if (noofrows > 0) {
				System.out.println("Deleted " + noofrows + "rows. ");
			}
			return getOrderList();
		}

		@Override
		public String payOrder(Orders order) {
			Query query = getSession().createQuery("update Orders me set orderTrackingNumber=:orderTrackingNumber where orderID =:id");
			String uuid = order.generateOrderTrackingNumber();
			query.setParameter("orderTrackingNumber",uuid);
			query.setParameter("id",order.getOrderID());
			
			
			
			int noofrows = query.executeUpdate();
			if (noofrows > 0) {
				System.out.println("Updated " + noofrows + "rows. ");
			}
			return uuid;
		}
}
