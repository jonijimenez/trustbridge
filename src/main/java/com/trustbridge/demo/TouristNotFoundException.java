package com.trustbridge.demo;

public class TouristNotFoundException extends RuntimeException {
    TouristNotFoundException(Long id) {
        super("Could not find tourist" + id);
    }
}
