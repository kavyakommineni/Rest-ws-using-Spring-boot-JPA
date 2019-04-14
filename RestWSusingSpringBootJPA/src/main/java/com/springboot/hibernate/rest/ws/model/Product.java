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
 * This class defines the Product object with the corresponding fields
 *
 */
@Entity(name="Product")
public class Product {

	@Id
	@Column(name="Product_Id",unique=true,updatable = false, nullable = false)
	private String id;
	@Column(name="Product_Name")
	private String name;
	@Column(name="Product_Description")
	private String description;
	@Column(name="Product_Price")
	private double price;
	@Column(name="Available_Stock")
	private int stock;
	
	@ManyToOne()
	@JoinColumn(name="Order_Id")
	private Orders order;
	
	@JsonIgnore
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<Seller> seller = new ArrayList<Seller>();
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public List<Seller> getSeller() {
		return seller;
	}
	public void setSeller(List<Seller> seller) {
		this.seller = seller;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Product(String id, String name, String description, double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	public Product() {
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
				+ stock + "]";
	}
}
