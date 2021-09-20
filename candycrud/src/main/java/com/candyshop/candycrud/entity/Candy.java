package com.candyshop.candycrud.entity;

import javax.persistence.*;

// TODO Remove all annotations and imports.
@Entity
public class Candy {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "composition")
    private String composition;

    public Candy() {
    }

    public Candy(String name, String composition, String additionalInformation) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.additionalInformation = additionalInformation;
    }

    @Column(name = "additionalInformation")
    private String additionalInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
