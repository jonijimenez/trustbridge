package com.trustbridge.demo.service;

//import com.trustbridge.demo.exception.OrderNotFoundException;
import com.trustbridge.demo.repository.OrderRepository;
import com.trustbridge.demo.model.Order;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

//    public Order patchOrder(Order body, Long id) {
//        return repository.findById(id)
//                .map(tourist -> {
//                    if (body.touristEmail != null) {
//                        tourist.touristEmail = body.touristEmail;
//                    }
//
//                    if (body.touristLocation != null) {
//                        tourist.touristLocation = body.touristLocation;
//                    }
//
//                    if (body.touristName != null) {
//                        tourist.touristName = body.touristName;
//                    }
//                    return repository.save(tourist);
//                }).orElseThrow(() -> new OrderNotFoundException(id));
//    }

    public Page<Order> findOrders(int page, int count) {
        Pageable pagedElems = PageRequest.of(page, count);
        return repository.findAll(pagedElems);
    }

//    public Order findOrderById(Long id) {
//        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
//    }

    public Order createOrder(Order newOrder) {
        return repository.save(newOrder);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
