package com.candyshop.customerscrud.entity;

import lombok.Data;

import java.util.List;
@Data
public class CustomerResponse {
    private List<Customer> customerList;
}
