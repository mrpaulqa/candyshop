package com.candyshop;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

interface CandyRepository extends JpaRepository<Candy, Long> {

}
