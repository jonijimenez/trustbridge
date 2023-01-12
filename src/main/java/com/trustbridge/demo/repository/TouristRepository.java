package com.trustbridge.demo.repository;

import com.trustbridge.demo.model.Tourist;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface TouristRepository extends PagingAndSortingRepository<Tourist, Long> {

}