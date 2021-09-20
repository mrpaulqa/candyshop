package com.candyshop.candycrud.exception;

// TODO Remove this class and package.
public class CandyNotFoundException extends RuntimeException {
    public CandyNotFoundException(Integer id) {
        super("Candy not found "+ id);
    }
}
