package com.candyshop.candycrud.repos;

import com.candyshop.candycrud.entity.Candy;
import org.springframework.data.repository.CrudRepository;

// TODO remove this interface and package
// What this will do interface will de fine how your will access your data.
public interface CandyRepository extends CrudRepository<Candy, Integer> {
}
