package com.candyshop.customerscrud;

import com.candyshop.customerscrud.entity.Customer;
import com.candyshop.customerscrud.entity.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    public CustomerResponse getAll() {
        Customer customer = new Customer();
        customer.setId(1);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerList(Arrays.asList(customer));
        return customerResponse;
    }

    @PostMapping(path="/customers/add")
    public @ResponseBody String addNewCustomer() {
        Customer c = new Customer();
        return "Saved";
    }
}
