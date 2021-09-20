package com.candyshop.customerscrud.exception;

// TODO Remove this class and package.
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Integer id) {
        super("Customer not found "+ id);
    }
}
