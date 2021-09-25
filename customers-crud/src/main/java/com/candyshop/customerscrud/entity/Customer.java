package com.candyshop.customerscrud.entity;


import lombok.Data;

@Data
public class Customer {

    private Integer id;
    private String name;
    Membership membership;
    Contact contact;
    
}


