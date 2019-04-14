package com.springboot.hibernate.rest.ws.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hibernate.rest.ws.model.Customer;
import com.springboot.hibernate.rest.ws.model.Orders;
import com.springboot.hibernate.rest.ws.model.Product;
import com.springboot.hibernate.rest.ws.model.Seller;
import com.springboot.hibernate.rest.ws.model.Shipment;
import com.springboot.hibernate.rest.ws.service.UserService;

/**
 * @author Kavya Kommineni
 * 
 * This is the controller class that maps the URL to the corresponding services and returns the requested results
 *
 */
@RestController
@RequestMapping("/shopping")
public class UserController {
	
	@Autowired
	private UserService service;
	
	URI location;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return service.getCustomers();
	}
	
	@GetMapping("/orders")
	public List<Orders> getOrders()
	{
		return service.getOrders();
	}
	
	@GetMapping("/products")
	public List<Product> getProducts()
	{
		return service.getProducts();
	}
	
	@GetMapping("/sellers")
	public List<Seller> getSellers()
	{
		return service.getSellers();
	}
	
	@GetMapping("/shipments")
	public List<Shipment> getShipments()
	{
		return service.getShipments();
	}
	
	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomerById(@Valid @PathVariable String id)
	{
		return service.getObjectByCustomerId(id);
	}
	
	@GetMapping("/orders/{id}")
	public Optional<Orders> getOrders(@Valid @PathVariable String id)
	{
		return service.getObjectByOrderId(id);
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProducts(@Valid @PathVariable String id)
	{
		return service.getObjectByProductId(id);
	}
	
	@GetMapping("/sellers/{id}")
	public Optional<Seller> getSellers(@Valid @PathVariable String id)
	{
		return service.getObjectBySellerId(id);
	}
	
	@GetMapping("/shipments/{id}")
	public Optional<Shipment> getShipments(@Valid @PathVariable String id)
	{
		return service.getObjectByShipmentId(id);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer cust)
	{
		Customer customer = service.addCustomer(cust);
		location = service.getLocation(customer.getId());	
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Object> addOrder(@RequestBody Orders ord)
	{
		Orders order = service.addOrder(ord);
		location = service.getLocation(order.getId());	
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/products")
	public ResponseEntity<Object> addProduct(@RequestBody Product pr)
	{
		Product product = service.addProduct(pr);
		location = service.getLocation(product.getId());	
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/sellers")
	public ResponseEntity<Object> addSeller(@RequestBody Seller sell)
	{
		Seller seller = service.addSeller(sell);
		location = service.getLocation(seller.getId());	
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/shipments")
	public ResponseEntity<Object> addShipment(@RequestBody Shipment ship)
	{
		Shipment shipment = service.addShipment(ship);
		location = service.getLocation(shipment.getId());
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer)
	{
		Customer cust = service.updateCustomer(customer);
		location = service.getLocation(cust.getId());
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<Object> updateOrder(@RequestBody Orders ord)
	{
		Orders order = service.updateOrder(ord);
		location = service.getLocation(order.getId());
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product pr)
	{
		Product product = service.updateProduct(pr);
		location = service.getLocation(product.getId());
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/sellers/{id}")
	public ResponseEntity<Object> updateSeller(@RequestBody Seller s)
	{
		Seller seller = service.updateSeller(s);
		location = service.getLocation(seller.getId());
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/shipments/{id}")
	public ResponseEntity<Object> updateShipment(@RequestBody Shipment s)
	{
		Shipment shipment = service.updateShipment(s);
		location = service.getLocation(shipment.getId());
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Object> deletCustomer(@Valid @PathVariable String id)
	{
		service.deleteCustomer(id);
		location = service.getLocation(id);
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Object> deleteOrder(@Valid @PathVariable String id)
	{
		service.deleteOrder(id);
		location = service.getLocation(id);
		return ResponseEntity.created(location).build();

	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@Valid @PathVariable String id)
	{
		service.deleteProduct(id);
		location = service.getLocation(id);
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/sellers/{id}")
	public ResponseEntity<Object> deleteSeller(@Valid @PathVariable String id)
	{
		service.deleteSeller(id);
		location = service.getLocation(id);
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/shipments/{id}")
	public ResponseEntity<Object> getLocation(@Valid String id)
	{
		service.deleteShipment(id);
		location = service.getLocation(id);
		return ResponseEntity.created(location).build();
	}
}
