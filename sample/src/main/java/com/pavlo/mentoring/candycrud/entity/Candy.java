package com.pavlo.mentoring.candycrud.entity;

import java.util.List;

public class Candy {
    String additionalInformation;
    List<String> compositions;

    public Candy(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }
}
