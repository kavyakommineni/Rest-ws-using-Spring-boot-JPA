package com.springboot.hibernate.rest.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.hibernate.rest.ws.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String>{

}
