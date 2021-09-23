package com.candyshop.customerscrud.entity;

public class Contact {

    Long customerId;

    public Contact() {
    }


    Customer customer;


    private String adress;


    private String email;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact(String adress, String email) {
        this.adress = adress;
        this.email = email;
    }
}
