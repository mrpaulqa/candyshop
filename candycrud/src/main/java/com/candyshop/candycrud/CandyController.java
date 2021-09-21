package com.candyshop.candycrud;

import com.candyshop.candycrud.entity.Candy;
import com.candyshop.candycrud.exception.CandyNotFoundException;
import com.candyshop.candycrud.repos.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO remove reference of Repository withtin the methods.
@RestController //Grants unique reference for this controller in springboot
public class CandyController {

    // TODO remove this
    @Autowired //Autowired in springboot will find this unique implementation and will assign that object
    private CandyRepository candyRepository;

    // @GetMapping: by having an url, let define GET Method
    @GetMapping("/candy")
    public String index() {
        return "Welcome to candy page";
    }

    // TODO Remove this method
    @GetMapping(path="/candies/all")
    // @ResponseBody: will assign your return to body of the response.
    public @ResponseBody
    Iterable<Candy> getAllUsers() {
        return candyRepository.findAll();
    }

    // TODO I have mentioned to not return the entity. Keep it simple.
    @GetMapping(path="/candies/{id}")
    // @PathVariable: get what ever is on {} in @GetMapping and will assign to your method parameter with the same name.
    Candy one(@PathVariable Integer id) {
        return candyRepository.findById(id).orElseThrow(() -> new CandyNotFoundException(id));
    }

    // TODO remove save
    @PostMapping(path="/candies/add")
    // @RequestParam will be present on the request body.
    public @ResponseBody String addNewCustomer (@RequestParam String name,
                                                @RequestParam String composition,
                                                @RequestParam String additionalInformation) {
        Candy c = new Candy(name,composition,additionalInformation);
        candyRepository.save(c);
        return "Saved";
    }
}
