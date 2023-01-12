package com.trustbridge.demo.controller;

import com.trustbridge.demo.repository.OrderRepository;
import com.trustbridge.demo.model.Order;
import com.trustbridge.demo.service.OrderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class OrderController {

    @Autowired
    OrderRepository repository;

    @Autowired
    OrderService service;

    @GetMapping("/order")
    Page<Order> all(@RequestParam(name = "page", defaultValue = "1") String page) {
        return service.findOrders(Integer.parseInt(page) - 1, 10);
    }

    @GetMapping("/order/{id}")
    Order findById(@PathVariable Long id) {
        return service.findOrderById(id);
    }

    @PostMapping("/order")
    Order newOrder(@RequestBody Order newOrder) {
        return service.createOrder(newOrder);
    }

    @PatchMapping("/order/{id}")
    Order patchOrder(@RequestBody Order newOrder, @PathVariable Long id) {
        return service.patchOrder(newOrder, id);
    }

    @DeleteMapping("/order/{id}")
    void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}