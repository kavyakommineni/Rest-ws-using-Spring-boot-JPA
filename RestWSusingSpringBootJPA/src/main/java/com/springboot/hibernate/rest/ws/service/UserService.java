package com.springboot.hibernate.rest.ws.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.hibernate.rest.ws.model.Customer;
import com.springboot.hibernate.rest.ws.model.Orders;
import com.springboot.hibernate.rest.ws.model.Product;
import com.springboot.hibernate.rest.ws.model.Seller;
import com.springboot.hibernate.rest.ws.model.Shipment;
import com.springboot.hibernate.rest.ws.repository.CustomerRepository;
import com.springboot.hibernate.rest.ws.repository.OrdersRepository;
import com.springboot.hibernate.rest.ws.repository.ProductRepository;
import com.springboot.hibernate.rest.ws.repository.SellerRepository;
import com.springboot.hibernate.rest.ws.repository.ShipmentRepository;

/**
 * @author Kavya Kommineni
 * This class provides the services requested by the client and returns the corresponding results to the controller
 *
 */
@Component
public class UserService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private OrdersRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Autowired
	private ShipmentRepository shipmentRepo;
	
	List<Customer> list =new ArrayList<Customer>();
	
	public List<Customer> getCustomers()
	{
		return customerRepo.findAll();
	}
	
	public List<Orders> getOrders()
	{
		return orderRepo.findAll();
	}
	
	public List<Product> getProducts()
	{
		return productRepo.findAll();
	}
	
	public List<Seller> getSellers()
	{
		return sellerRepo.findAll();
	}
	
	public List<Shipment> getShipments()
	{
		return shipmentRepo.findAll();
	}
	
	public Optional<Customer> getObjectByCustomerId(String id)
	{
		return customerRepo.findById(id);
	}
	
	public Optional<Orders> getObjectByOrderId(String id)
	{
		return orderRepo.findById(id);
	}
	
	public Optional<Product> getObjectByProductId(String id)
	{
		return productRepo.findById(id);
	}
	
	public Optional<Seller> getObjectBySellerId(String id)
	{
		return sellerRepo.findById(id);
	}
	
	public Optional<Shipment> getObjectByShipmentId(String id)
	{
		return shipmentRepo.findById(id);
	}
	
	public Customer addCustomer(Customer cust)
	{
		Customer savedCustomer = customerRepo.save(cust);
		return savedCustomer;
	}
	
	public Orders addOrder(Orders order)
	{
		Orders savedOrder = orderRepo.save(order);
		return savedOrder;
	}
	
	public Product addProduct(Product product)
	{
		Product savedProduct = productRepo.save(product);
		return savedProduct;
	}
	
	public Seller addSeller(Seller seller)
	{
		Seller savedSeller = sellerRepo.save(seller);
		return savedSeller;
	}
	
	public Shipment addShipment(Shipment shipment)
	{
		Shipment savedShipment = shipmentRepo.save(shipment);
		return savedShipment;
	}
	
	public Customer updateCustomer(Customer c)
	{
		Optional<Customer> cust = customerRepo.findById(c.getId());
		
		Customer customer = cust.get();
		System.out.println(customer.getName());
		System.out.println(c.getName());
		
		customer.setAddress(c.getAddress());
		customer.setName(c.getName());
		
		return customerRepo.save(customer);
	}
	
	public Orders updateOrder(Orders ord)
	{
		Optional<Orders> order = orderRepo.findById(ord.getId());
		
		Orders o = order.get();
		
		o.setCost(ord.getCost());
		o.setStatus(ord.getStatus());
		o.setCustomer(ord.getCustomer());
		
		return orderRepo.save(o);
	}
	
	public Seller updateSeller(Seller s)
	{
		Optional<Seller> sell = sellerRepo.findById(s.getId());
		
		Seller seller = sell.get();
		
		seller.setAddress(s.getAddress());
		seller.setName(s.getName());
		seller.setNumber(s.getNumber());
		seller.setRating(s.getRating());
		seller.setProduct(s.getProduct());
		
		return sellerRepo.save(seller);
	}
	
	public Product updateProduct(Product p)
	{
		Optional<Product> pr = productRepo.findById(p.getId());
		
		Product product = pr.get();
		
		product.setName(p.getName());
		product.setDescription(p.getDescription());
		product.setOrder(p.getOrder());
		product.setPrice(p.getPrice());
		product.setStock(p.getStock());
		
		return productRepo.save(product);
	}
	
	public Shipment updateShipment(Shipment s)
	{
		Optional<Shipment> ship = shipmentRepo.findById(s.getId());
		
		Shipment shipment = ship.get();
		
		shipment.setDate(s.getDate());
		shipment.setSeller(s.getSeller());
		
		return shipmentRepo.save(shipment);
	}
	
	public void deleteCustomer(String id)
	{
		customerRepo.deleteById(id);
	}
	
	public void deleteOrder(String id)
	{
		orderRepo.deleteById(id);
	}
	
	public void deleteProduct(String id)
	{
		productRepo.deleteById(id);
	}
	
	public void deleteSeller(String id)
	{
		sellerRepo.deleteById(id);
	}
	
	public void deleteShipment(String id)
	{
		shipmentRepo.deleteById(id);
	}
	
	public URI getLocation(String id)
	{
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()  //Gets the current request (/shopping/customers)
				.path("/{id}")  //Appends the id field to the current uri
				.buildAndExpand(id)  //Replaces id with the id of the corresponding id from backend that is generated
				.toUri();
		return location;
	}
}