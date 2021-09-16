package com.candyshop.exception;

public class CandyNotFoundException extends RuntimeException{
    public CandyNotFoundException(Long id) {
        super("Could not find candy " + id);
    }
}
