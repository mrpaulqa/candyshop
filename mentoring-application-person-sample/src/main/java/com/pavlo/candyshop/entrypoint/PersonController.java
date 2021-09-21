package com.pavlo.candyshop.entrypoint;

import com.pavlo.candyshop.entity.PeopleResponse;
import com.pavlo.candyshop.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class PersonController {

    @GetMapping("/person")
    public PeopleResponse getAll() {
        Person c = new Person();
        c.setId(1);
        PeopleResponse response = new PeopleResponse();
        response.setPeople(Arrays.asList(c));

        return response;
    }

    @GetMapping(path="/person/{id}")
    public Person get(@PathVariable Integer id){
        Person c = new Person();
        c.setId(id);

        return c;
    }
}
