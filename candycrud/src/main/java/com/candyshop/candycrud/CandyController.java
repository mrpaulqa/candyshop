package com.candyshop.candycrud;

import com.candyshop.candycrud.entity.Candy;
import com.candyshop.candycrud.exception.CandyNotFoundException;
import com.candyshop.candycrud.repos.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CandyController {
    @Autowired
    private CandyRepository candyRepository;

    @GetMapping("/candy")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path="/candies/all")
    public @ResponseBody
    Iterable<Candy> getAllUsers() {
        return candyRepository.findAll();
    }

    @GetMapping(path="/candies/{id}")
    Candy one(@PathVariable Integer id){
        return candyRepository.findById(id).orElseThrow(()->new CandyNotFoundException(id));
    }

    @PostMapping(path="/candies/add")
    public @ResponseBody String addNewCustomer (@RequestParam String name,
                                                @RequestParam String composition,
                                                @RequestParam String additionalInformation) {
        Candy c = new Candy(name,composition,additionalInformation);
        candyRepository.save(c);
        return "Saved";
    }
}
