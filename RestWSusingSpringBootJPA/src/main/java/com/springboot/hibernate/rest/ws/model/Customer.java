package com.springboot.hibernate.rest.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Kavya Kommineni
 * This class defines the customer object with the corresponding fields
 *
 */
@Entity(name="Customer")
public class Customer {

	@Id
	@Column(name="Customer_Id",unique=true,updatable = false, nullable = false)
	private String id;
	@Column(name="Customer_Name")
	private String name;
	@Column(name="Customer_Address")
	private String address;
	@Column(name="Customer_Password")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Orders> orders = new ArrayList<Orders>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Customer(String id, String name, String address,String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.password = password;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", password=" + password + "]";
	}
}
