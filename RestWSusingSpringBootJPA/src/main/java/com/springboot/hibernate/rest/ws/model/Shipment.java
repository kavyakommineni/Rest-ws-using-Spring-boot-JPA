package com.springboot.hibernate.rest.ws.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Kavya Kommineni
 * This class defines the Shipment object with the corresponding fields
 *
 */
@Entity(name="Shipment")
public class Shipment {
	
	@Id
	@Column(name="Shipment_Id",unique=true,updatable = false, nullable = false)
	private String id;
	@Temporal(TemporalType.DATE)
	@Column(name="Shipment_Date")
	private Date date;
	
	@ManyToOne()
	@JoinColumn(name="Seller_Id")
	private Seller seller;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Shipment(String id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	public Shipment() {
		
	}
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", date=" + date + "]";
	}
}
