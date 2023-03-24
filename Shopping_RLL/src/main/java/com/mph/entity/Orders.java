package com.mph.entity;


import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 
 * 
 * @author Prasanna_Palanivel
 *
 */
@Entity
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;


    private String orderTrackingNumber;

    
    private int totalPrice;


   @OneToMany(cascade = CascadeType.ALL, mappedBy = "order",fetch = FetchType.EAGER )
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


 private String address;

    
    public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

    public String generateOrderTrackingNumber() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        return  uuid;

    }
	public Orders(int orderID, String orderTrackingNumber, int totalPrice, Set<OrderItem> orderItems, Customer customer,
			String address) {
		super();
		this.orderID = orderID;
		this.orderTrackingNumber = orderTrackingNumber;
		this.totalPrice = totalPrice;
		this.orderItems = orderItems;
		this.customer = customer;
		this.address = address;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}


	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", orderTrackingNumber=" + orderTrackingNumber + ", totalPrice="
				+ totalPrice + ", orderItems=" + orderItems + ", customer=" + customer + ", address=" + address + "]";
	}




/*	public void add(ProductCart item) {
        if(item != null) {
            if(orderItems == null) {
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }
*/


	
}
