package com.pavlo.mentoring.candycrud.entrypoint;

import com.pavlo.mentoring.candycrud.entity.Candy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CandyController {
    @GetMapping("/candies")
    public String getAllCandies() {
        List<Candy> candies = new ArrayList<>();
        candies.add(new Candy("this is soft candy"));
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Candy c: candies){
            sb.append("Candy( "+ c.getAdditionalInformation() + ")");
        }
        sb.append("[");
        return sb.toString();
    }

}
