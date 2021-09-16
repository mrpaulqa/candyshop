package com.candyshop.repository;


import com.candyshop.entity.Candy;
import org.springframework.data.repository.CrudRepository;


public interface CandyRepository extends CrudRepository<Candy, Long> {
}
