package com.trustbridge.demo.exception;

public class TouristNotFoundException extends RuntimeException {
    public TouristNotFoundException(Long id) {
        super("Could not find tourist" + id);
    }
}
