package com.candyshop.customerscrud.entity;

import javax.persistence.*;
import java.util.List;

// TODO Remove all annotations and imports.
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    private String membership;


    public Customer() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public Customer(String name, String membership) {
        this.name = name;

//        this.contact_info = contact_info;
        this.membership = membership;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}


