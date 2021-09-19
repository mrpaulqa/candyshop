package com.candyshop.customerscrud;

import com.candyshop.customerscrud.entity.Customer;
import com.candyshop.customerscrud.exception.CustomerNotFoundException;
import com.candyshop.customerscrud.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path="/customers/all")
    public @ResponseBody
    Iterable<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @GetMapping(path="/customers/{id}")
    Customer one(@PathVariable Integer id){

        return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException(id));
    }


    @PostMapping(path="/customers/add")
    public @ResponseBody String addNewCustomer (@RequestParam String name, @RequestParam String role) {
        Customer c = new Customer(name,role);
        customerRepository.save(c);
        return "Saved";
    }
}
