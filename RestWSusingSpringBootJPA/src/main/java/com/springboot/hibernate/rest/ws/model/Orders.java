package com.springboot.hibernate.rest.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Kavya Kommineni
 * This class defines the Orders object with the corresponding fields
 *
 */
@Entity(name="Orders")
public class Orders {

	@Id
	@Column(name="Order_Id",unique=true,updatable = false, nullable = false)
	private String id;
	@Column(name="Order_Cost")
	private double cost;
	@Column(name="Order_Status")
	private String status;
	
	@ManyToOne()
	@JoinColumn(name="Customer_Id")
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(mappedBy="order", cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Orders(String id, double cost, String status) {
		super();
		this.id = id;
		this.cost = cost;
		this.status = status;
	}
	public Orders() {
		
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", cost=" + cost + ", status=" + status + "]";
	}
}
