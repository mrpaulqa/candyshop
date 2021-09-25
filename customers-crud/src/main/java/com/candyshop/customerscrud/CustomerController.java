package com.candyshop.customerscrud;

import com.candyshop.customerscrud.entity.Customer;
import com.candyshop.customerscrud.entity.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class CustomerController {
     public final static Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    @GetMapping("/customers")
    public CustomerResponse getAll() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test");
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerList(Arrays.asList(customer));
        return customerResponse;
    }

    @PostMapping(path="/customers/add")
    public @ResponseBody String addNewCustomer (@RequestBody Customer customer) {
        customer.setName(customer.getName());
        customer.setMembership(customer.getMembership());
        customer.setContact(customer.getContact());
        return "Saved";
    }

    @PutMapping(value = "/customers/update/{id}")
    public Customer updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
        customer.setName(customer.getName());
        customer.setMembership(customer.getMembership());
        customer.setContact(customer.getContact());
        LOGGER.info(customer.toString());
        return customer;
    }

    @DeleteMapping(value = "/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        getAll().getCustomerList().remove(id);
        return "Deleted candy with id: "+id;
    }

    @PatchMapping(value = "/customers/patch/{id}")
    public @ResponseBody String updateCustomerPartially(@PathVariable Integer id, @RequestBody Map<String,Object> changes){

        return "";
    }


}

