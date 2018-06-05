package com.example.springmobgodbsport.resource;

import com.example.springmobgodbsport.document.Order;
import com.example.springmobgodbsport.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dashboard")
public class OrderDashboard {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/{country}")
    public List<Order> filterByCountry(@PathVariable String country) {
        return orderRepository.findByCountry(country);
    }

    @GetMapping("**")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
