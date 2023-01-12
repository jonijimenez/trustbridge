package com.trustbridge.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;


@Entity
@Table(name="product")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String productName;

    public String productDescription;
}