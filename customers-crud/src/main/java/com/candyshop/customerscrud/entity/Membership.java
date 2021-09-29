package com.candyshop.customerscrud.entity;

import lombok.Data;

@Data
public class Membership {
    Integer id;
    String label;
    Discount discount;
}
