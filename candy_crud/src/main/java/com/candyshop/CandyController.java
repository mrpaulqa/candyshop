package com.candyshop;


import java.util.List;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CandyController {

    private final CandyRepository candyRepository;

    CandyController(CandyRepository candyRepository) {
        this.candyRepository = candyRepository;
    }

    @GetMapping("/candies")
    CollectionModel<EntityModel<Candy>> all() {

        List<EntityModel<Candy>> candies = candyRepository.findAll().stream()
                .map(candy -> EntityModel.of(candy,
                        linkTo(methodOn(CandyController.class).one(candy.getId())).withSelfRel(),
                        linkTo(methodOn(CandyController.class).all()).withRel("candies")))
                .collect(Collectors.toList());

        return CollectionModel.of(candies, linkTo(methodOn(CandyController.class).all()).withSelfRel());
    }

    @PostMapping("/candies")
    Candy newCandy(@RequestBody Candy newCandy) {
        return candyRepository.save(newCandy);
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



