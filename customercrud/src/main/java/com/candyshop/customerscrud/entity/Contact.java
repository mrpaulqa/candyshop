package com.candyshop.customerscrud.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Long customerId;

    public Contact() {
    }

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    Customer customer;

    @Column(name = "adress")
    private String adress;

    @Column(name = "email")
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
