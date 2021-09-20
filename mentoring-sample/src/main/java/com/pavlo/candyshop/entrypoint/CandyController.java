package com.pavlo.candyshop.entrypoint;

import com.pavlo.candyshop.entity.CandiesResponse;
import com.pavlo.candyshop.entity.Candy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CandyController {

    @GetMapping("/candy")
    public CandiesResponse getAll() {
        Candy c = new Candy();
        c.setId(1);
        CandiesResponse response = new CandiesResponse();
        response.setCandies(Arrays.asList(c));

        return response;
    }

    @GetMapping(path="/candy/{id}")
    public Candy get(@PathVariable Integer id){
        Candy c = new Candy();
        c.setId(id);

        return c;
    }
}
