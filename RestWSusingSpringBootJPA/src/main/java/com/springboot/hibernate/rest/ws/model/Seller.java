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
 * This class defines the Seller object with the corresponding fields
 *
 */
@Entity
public class Seller {

	@Id
	@Column(name="Seller_Id",unique=true,updatable = false, nullable = false)
	private String id;
	@Column(name="Seller_Name")
	private String name;
	@Column(name="Seller_Address")
	private String address;
	@Column(name="Contact_Number")
	private String number;
	@Column(name="Seller_Rating")
	private double rating;
	
	@ManyToOne()
	@JoinColumn(name="Product_Id")
	private Product product;
	
	@JsonIgnore
	@OneToMany(mappedBy="seller", cascade=CascadeType.ALL)
	private List<Shipment> shipment = new ArrayList<Shipment>();
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Shipment> getShipment() {
		return shipment;
	}
	public void setShipment(List<Shipment> shipment) {
		this.shipment = shipment;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Seller(String id, String name, String address, String number, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.rating = rating;
	}
	public Seller() {
		super();
	}
	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", address=" + address + ", number=" + number + ", rating="
				+ rating + "]";
	}
}
