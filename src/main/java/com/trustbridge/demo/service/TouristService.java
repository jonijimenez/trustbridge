package com.trustbridge.demo.service;

import com.trustbridge.demo.exception.TouristNotFoundException;
import com.trustbridge.demo.repository.TouristRepository;
import com.trustbridge.demo.model.Tourist;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

@Service
public class TouristService {

    @Autowired
    TouristRepository repository;

    public Tourist patchTourist(Tourist body, Long id) {
        return repository.findById(id)
           .map(tourist -> {
               if (body.touristEmail != null) {
                   tourist.touristEmail = body.touristEmail;
               }

               if (body.touristLocation != null) {
                   tourist.touristLocation = body.touristLocation;
               }

               if (body.touristName != null) {
                   tourist.touristName = body.touristName;
               }
               return repository.save(tourist);
           }).orElseThrow(() -> new TouristNotFoundException(id));
    }

    public Page<Tourist> findTourists(int page, int count) {
        Pageable pagedElems = PageRequest.of(page, count, Sort.by("touristEmail").ascending());
        return repository.findAll(pagedElems);
    }

    public Tourist findTouristById(Long id) {
        return repository.findById(id).orElseThrow(() -> new TouristNotFoundException(id));
    }

}
