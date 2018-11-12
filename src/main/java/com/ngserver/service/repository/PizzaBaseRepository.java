package com.ngserver.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ngserver.service.product.Pizza;
import com.ngserver.service.product.PizzaBase;

public interface PizzaBaseRepository extends JpaRepository<PizzaBase, Long> {
	@Query("select b from PizzaBase b where b.name = :pizzaBaseName")
	List<PizzaBase> find(@Param ( "pizzaBaseName") String pizzaBaseName) ;

}
