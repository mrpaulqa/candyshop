package com.pavlo.mentoring.candycrud.entrypoint;

import com.pavlo.mentoring.candycrud.entity.Candy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Over here we will have our get/post/put methods.
@RestController
public class CandyController {

    @GetMapping("/candy")
    public String getAllCandies() {
        List<Candy> candies = new ArrayList<>();
        candies.add(new Candy("this is a soft candy"));

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Candy c: candies) {
            sb.append("Candy(" + c.getAdditionalInformation() + "),");
        }
        sb.append("]");
        return sb.toString();
    }

    //1) first home work
        //Post
            // received System.out.println(object.toString());
        //Patch
            // will receive an ID
            // received System.out.println(object.toString())

    //2) create sub project in candyshop based on
        // https://github.com/mrpaulqa/candyshop/projects

    //3) Will be to install on your machine Docker
}
