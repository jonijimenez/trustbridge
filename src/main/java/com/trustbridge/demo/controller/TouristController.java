package com.trustbridge.demo.controller;

import com.trustbridge.demo.repository.TouristRepository;
import com.trustbridge.demo.model.Tourist;
import com.trustbridge.demo.service.TouristService;
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
public class TouristController {

    @Autowired
    TouristRepository repository;

    @Autowired
    TouristService service;

    TouristController(TouristRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tourist")
    Page<Tourist> all(@RequestParam(name = "page", defaultValue = "0") String page) {
        return service.findTourists(Integer.parseInt(page) - 1, 10);
    }

    @GetMapping("/tourist/{id}")
    Tourist findById(@PathVariable Long id) {
        return service.findTouristById(id);
    }

    @PostMapping("/tourist")
    Tourist newTourist(@RequestBody Tourist newTourist) {
        return repository.save(newTourist);
    }

    @PatchMapping("/tourist/{id}")
    Tourist patchTourist(@RequestBody Tourist newTourist, @PathVariable Long id) {
        return service.patchTourist(newTourist, id);

    }

    @DeleteMapping("/tourist/{id}")
    void deleteTourist(@PathVariable Long id) {
        repository.deleteById(id);
    }



}