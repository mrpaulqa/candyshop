package com.candyshop.customerscrud;

import com.candyshop.customerscrud.entity.Customer;
import com.candyshop.customerscrud.exception.CustomerNotFoundException;
import com.candyshop.customerscrud.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO remove reference of Repository withtin the methods.
@RestController
public class CustomerController {

    // TODO remove this
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    // TODO Remove this method
    @GetMapping(path="/customers/all")
    public @ResponseBody
    Iterable<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    // TODO I have mentioned to not return the entity. Keep it simple.
    @GetMapping(path="/customers/{id}")
    Customer one(@PathVariable Integer id){
        return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException(id));
    }

    // TODO remove save
    @PostMapping(path="/customers/add")
    public @ResponseBody String addNewCustomer (@RequestParam String name, @RequestParam String role) {
        Customer c = new Customer(name,role);
        customerRepository.save(c);
        return "Saved";
    }
}
