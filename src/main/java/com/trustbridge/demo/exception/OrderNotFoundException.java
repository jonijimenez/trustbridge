package com.trustbridge.demo.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Could not find tourist" + id);
    }
}
