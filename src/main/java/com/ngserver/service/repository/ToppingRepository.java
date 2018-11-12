package com.ngserver.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ngserver.service.product.Topping;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
	@Query("select b from Topping b where b.name = :toppingName")
	List<Topping> find(@Param ( "toppingName") String toppingName) ;

}
