package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Customer;
/**
 * 
 * @author Pratheeksha
 * @version 1.0
 * 
 *
 */


@Repository
public class CustomerDaoImpl implements CustomerDao {

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
	public void createCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		System.out.println("Employee Stored in DB Successfully !!!");
	}

	/**
	   * This method is used to insert employees in database. 
	   * @param No parameter
	   * 
	   * @return List<Employee> list of employees
	   */
	@Override
	public List<Customer> getCustomerList() {
		Query query = getSession().createQuery("select me from Customer me");
		List<Customer> customerList = query.list();
		return customerList;
	}

	@Override
	public Customer getCustomer(Customer customer) {
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("email", customer.getEmail()));
		Customer cus1 = (Customer) c.uniqueResult();
		return cus1;
	}

	
	@Override
	public List<Customer> updateCustomer(Customer customer) {
		Query query = getSession().createQuery("update Customer me set customerFirstname=:customerFirstname,customerLastname=:customerLastname,gender=:gender where customerid =:customerid");
		query.setParameter("customerFirstname",customer.getCustomerFirstname());
		query.setParameter("customerLastname",customer.getCustomerLastname());
		query.setParameter("gender",customer.getGender());
		query.setParameter("customerid",customer.getCustomerId());
		
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getCustomerList();
	}

	/*@Override
	public List<Employee> deleteEmployee(int eid) {
		Query query = getSession().createQuery("delete Employee me where eid =:eid");
		query.setParameter("eid", eid);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getEmployeeList();
	}
*/
	
	@Override
	public Customer getCustomerById(int customerId) {
		
		Query query = getSession().createQuery("from Customer me where customerId =:eid");
		query.setParameter("eid", customerId);
		Customer emp = (Customer) query.uniqueResult();
		
		return emp;
	}
	/*
	@Override
	public Employee search(String name) {
		Query query = getSession().createQuery("select me Employee me where fname =:fname");
		query.setParameter("fname", name);
		Employee emp = (Employee) query.uniqueResult();
		return emp;
	}*/


}