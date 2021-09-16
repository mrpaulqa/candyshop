package com.candyshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String additionalInformation;
    List<String> composition;

    public Candy() {
    }

    public Candy(Long id, String additionalInformation) {
        this.id = id;
        this.additionalInformation = additionalInformation;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public List<String> getComposition() {
        return composition;
    }

    public Candy(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setComposition(List<String> composition) {
        this.composition = composition;
    }
}
