package com.candyshop.customerscrud.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Integer id) {
        super("Customer not found "+ id);
    }
}
