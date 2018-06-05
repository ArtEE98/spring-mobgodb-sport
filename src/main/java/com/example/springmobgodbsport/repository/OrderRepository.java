package com.example.springmobgodbsport.repository;

import com.example.springmobgodbsport.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface OrderRepository extends MongoRepository<Order, Integer>{
    List<Order> findByCountry(String country);
}
