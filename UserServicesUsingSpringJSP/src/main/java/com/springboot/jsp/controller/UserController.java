package com.springboot.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jsp.model.Customer;
import com.springboot.jsp.model.Orders;
import com.springboot.jsp.model.User;

/**
 * @author Kavya Kommineni
 * This is the controller class which acts as a interface between the UI and the back end.
 * In this class I am calling external REST API to fetch and compare the results.
 *
 */
@Controller
@RequestMapping("users")
public class UserController {

	List<User> list = new ArrayList<User>();
	List<Orders> orderList = new ArrayList<Orders>();
	RestTemplate restTemplate = new RestTemplate();
	static Customer cust;
	
	/**
	 * When the URL is called, it comes to this method and displays the Login page
	 * @param request
	 * @return
	 */
	@RequestMapping(value="Login")
	public ModelAndView userLogin(WebRequest request)
	{
		ModelAndView model = new ModelAndView("Login");
		request.removeAttribute("message", WebRequest.SCOPE_REQUEST);
		model.addObject("user",new User());
		return model;
	}
	
	/**
	 * When the link to Register is called, this method displays the Register page
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="Register")
	public ModelAndView userRegister(Customer customer)
	{
		ModelAndView model = new ModelAndView("Register");
		model.addObject("user",new User());
		return model;
	}
	
	/**
	 * This method is called when the Login button is clicked. It checks the
	 * username and password and allows to log in only if they are already
	 * registered and are correct.
	 * 
	 * @param u
	 * @return
	 */
	@RequestMapping(value="loginCheck", method= RequestMethod.POST)
	public ModelAndView loginCheck(User u)
	{
		ModelAndView model = new ModelAndView();
		
		cust = restTemplate.getForObject("http://localhost:8080/shopping/customers/".concat(u.getName()), Customer.class);
		
		if (u.getName() != null && u.getPassword() != null && cust != null
				&& (u.getName().equals(cust.getId()) && u.getPassword().equals(cust.getPassword())))
		{
			model.setViewName("redirect:/users/Orders");
		}
		else
		{
			model.setViewName("redirect:/users/Login");
		}
		
		return model;
	}
	
	/**
	 * This method is called when the Register button is clicked. It allows the user
	 * to register and saves the user details to the database
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="addUser", method= RequestMethod.POST)
	public ModelAndView addUser(Customer customer)
	{
		ModelAndView model = new ModelAndView();
		
		restTemplate.postForObject(
				  "http://localhost:8080/shopping/customers",
				  customer,
				  Customer.class);
		
		model.setViewName("redirect:/users/Login");
		return model;
	}
	
	/**
	 * This method is called when the URL for Orders is called. It calls external
	 * REST service running on another port to get the ordes associated with the
	 * logged in customer
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="Orders")
	public ModelAndView userOrders(WebRequest request)
	{
		orderList = new ArrayList<Orders>();
		
		Orders orders = null;
		
		for(int i = 1;i<=10;i++)
		{
			orders = restTemplate.getForObject("http://localhost:8080/shopping/orders/order".concat(String.valueOf(i)), Orders.class);

			if(orders!=null && (orders.getCustomer().getId().equals(cust.getId())))
			{
				orderList.add(orders);
			}
		}
		
		ModelAndView model = new ModelAndView("Orders");
		request.removeAttribute("message", WebRequest.SCOPE_REQUEST);
		model.addObject("orderList",orderList);
		model.addObject("name",cust.getName());
		model.addObject("customer",new Customer());
		return model;
	}
}