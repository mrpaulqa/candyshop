package com.candyshop.candycrud.exception;

public class CandyNotFoundException extends RuntimeException {
    public CandyNotFoundException(Integer id) {
        super("Candy not found "+ id);
    }
}
