package com.trustbridge.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;


@Entity
@Table(name="tourist")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long id;

//    @Column(name="tourist_name")
    public String touristName;

//    @Column(name="tourist_email")
    public String touristEmail;

//    @Column(name="tourist_location")
    public String touristLocation;

    Tourist() {}

//    public Tourist(String name, String email, String location) {
//        this.setTouristName(name);
//        this.setTouristEmail(email);
//        this.setTouristLocation(location);
//    }

//    public String getTouristName() {
//        return this.tourist_name;
//    }
//
//    public String getTouristEmail() {
//        return this.tourist_email;
//    }
//
//    public String getTouristLocation() {
//        return this.tourist_location;
//    }

//    public void setTouristName(String name) {
//        this.tourist_name = name;
//    }
//
//    public void setTouristEmail(String email) {
//        this.tourist_email = email;
//    }
//
//    public void setTouristLocation(String location) {
//        this.tourist_location = location;
//    }

//    @Override
//    public String toString() {
//        return "Tourist{" + "id=" + this.id + ", name='" + this.touristName + '\'' + ", email='" + this.touristEmail + '\'' + '}';
//    }
}