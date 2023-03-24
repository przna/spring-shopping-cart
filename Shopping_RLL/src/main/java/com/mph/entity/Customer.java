package com.mph.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Column
	private String customerFirstname;
	@Column
	private String customerLastname;
	@Column
	private String gender;
	@Column
	private String email;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Orders> orders = new HashSet<>();

	@Column
	private String dateOfBirth;
	
	@Column
	private String password;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customerFirstname, String customerLastname, String gender, String email,
			Set<Orders> orders, String dateOfBirth, String password) {
		super();
		this.customerId = customerId;
		this.customerFirstname = customerFirstname;
		this.customerLastname = customerLastname;
		this.gender = gender;
		this.email = email;
		this.orders = orders;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerid(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstname() {
		return customerFirstname;
	}

	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}

	public String getCustomerLastname() {
		return customerLastname;
	}

	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Customer [customerid=" + customerId + ", customerFirstname=" + customerFirstname + ", customerLastname="
				+ customerLastname + ", gender=" + gender + ", email=" + email + ", orders=" + orders + ", dateOfBirth="
				+ dateOfBirth + ", password=" + password + ", passwordConfirm=" + "]";
	}

	

	
	
}