package  com.mentoring.candycrud.entity;

import java.util.List;

public class Candy {
    String additionalInformation;
    List<String> composition;

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public List<String> getComposition() {
        return composition;
    }

    public Candy(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
