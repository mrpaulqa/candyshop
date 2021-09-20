package com.candyshop.customerscrud.repos;

import com.candyshop.customerscrud.entity.Customer;
import org.springframework.data.repository.CrudRepository;

// TODO remove this interface and package
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
