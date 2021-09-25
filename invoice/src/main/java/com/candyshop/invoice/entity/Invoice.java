package com.candyshop.invoice.entity;

import com.candyshop.customerscrud.entity.Customer;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Invoice {
    LocalDate date;
    Customer customer;
    List<String> items;
    List<String> discount;


}
