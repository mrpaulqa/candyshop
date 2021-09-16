package com.candyshop.entrypoint;

import com.candyshop.entity.Candy;
import com.candyshop.exception.CandyNotFoundException;
import com.candyshop.repository.CandyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CandyController {
    private final CandyRepository candyRepository;

    CandyController(CandyRepository candyRepository) {
        this.candyRepository = candyRepository;
    }

    @GetMapping("/candies")
    public String findAll(Model model){
        Iterable<Candy> result =candyRepository.findAll();
        model.addAttribute("candies",result);
        return "candies";
    }

    @PostMapping("/candies")
    Candy newCandy(@RequestBody Candy newEmployee) {
        return candyRepository.save(newEmployee);
    }
    // Single item

    @GetMapping("/employees/{id}")
    Candy one(@PathVariable Long id) {

        return candyRepository.findById(id)
                .orElseThrow(() -> new CandyNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Candy replaceEmployee(@RequestBody Candy newCandy, @PathVariable Long id) {
        return candyRepository.findById(id)
                .map(candy -> {
                    candy.setAdditionalInformation(newCandy.getAdditionalInformation());
                    return candyRepository.save(candy);
                })
                .orElseGet(() -> {
                    newCandy.setId(id);
                    return candyRepository.save(newCandy);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        candyRepository.deleteById(id);
    }



    }



