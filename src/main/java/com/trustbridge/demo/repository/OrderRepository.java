package com.trustbridge.demo.repository;

import com.trustbridge.demo.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}