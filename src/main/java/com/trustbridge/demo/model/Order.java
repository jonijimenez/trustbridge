package com.trustbridge.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name="tb_order")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // this is a tourist id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ordered_by")
    @PrimaryKeyJoinColumn(name="tourist_id")
    public Tourist tourist;

    @CreationTimestamp
    public Timestamp dateOrdered;

    public String status;

    // this is the product id
    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "product_id")
    public Product product;
}