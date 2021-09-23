package com.candyshop.candycrud;

import com.candyshop.candycrud.entity.Candy;
import com.candyshop.candycrud.entity.CandyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
public class CandyController {

    @GetMapping("/candy")
    public CandyResponse getAll(){
        Candy candy = new Candy();
        candy.setId(1);
        CandyResponse candyResponse = new CandyResponse();
        candyResponse.setCandyList(Arrays.asList(candy));
        return candyResponse;
    }

    @PostMapping(path="/candies/add")
    public @ResponseBody String addNewCandy () {
        Candy c = new Candy();
        return "Saved";
    }
}
