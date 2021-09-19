package com.candyshop.candycrud.repos;

import com.candyshop.candycrud.entity.Candy;
import org.springframework.data.repository.CrudRepository;

public interface CandyRepository extends CrudRepository<Candy, Integer> {
}
