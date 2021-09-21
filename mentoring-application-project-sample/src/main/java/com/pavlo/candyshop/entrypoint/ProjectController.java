package com.pavlo.candyshop.entrypoint;

import com.pavlo.candyshop.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private PersonService personService;

    @GetMapping(path="/project/{id}")
    public Project get(@PathVariable Integer id){
        Project p = new Project();
        p.setId(id);
        p.setIllegible(this.personService.getAllPeople().getPeople());
        return p;
    }
}
