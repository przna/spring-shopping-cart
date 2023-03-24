package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private int orderID;

    private String productName;
    private String imageUrl;

    
    private int unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;


	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderItem(int orderID, String productName, String imageUrl, int unitPrice, 
			Orders order) {
		super();
		this.orderID = orderID;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.unitPrice = unitPrice;
		this.order = order;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	public Orders getOrder() {
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "OrderItem [orderID=" + orderID + ", productName=" + productName + ", imageUrl=" + imageUrl
				+ ", unitPrice=" + unitPrice + ", order=" + order + "]";
	}


}
