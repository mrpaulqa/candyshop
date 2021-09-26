package com.candyshop.candycrud.entrypoint;

import com.candyshop.candycrud.entity.Candy;
import com.candyshop.candycrud.entity.CandyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;


@RestController
public class CandyController {

    public final static Logger LOGGER = Logger.getLogger(CandyController.class.getName());
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

    @GetMapping(path="/candies/{id}")
    public Candy get(@PathVariable Integer id){
        Candy c = new Candy();
        c.setId(id);
        return c;
    }

    @PutMapping(value = "/candies/update/{id}")
    public Candy updateCandy(@PathVariable Integer id,@RequestBody Candy candy){
        candy.setId(candy.getId());
        candy.setName(candy.getName());
        candy.setComposition(candy.getComposition());
        LOGGER.info(candy.toString());
        return candy;
    }

    @DeleteMapping(value = "/candies/delete/{id}")
    public String deleteCandy(@PathVariable Integer id){
        getAll().getCandyList().remove(id);
        return "Deleted candy with id: "+id;
    }

    @PatchMapping(value = "/candies/patch/{id}")
    public @ResponseBody String updateCandyPartially(@PathVariable Integer id, @RequestBody Map<String,Object> changes){
        Candy candy = new Candy();
        candy.setId(5);
        candy.setName("Test");
        candy.setComposition("Composition");
        CandyResponse candyResponse = new CandyResponse();
        candyResponse.getCandyList().add(candy);
        changes.forEach(
                (change, value) -> {
                    switch (change){
                        case "name": candy.setName((String) value); break;
                        case "composition": candy.setComposition((String) value); break;
                    }
                });
        return "Patched: "+candy;
    }
}
