package com.ngserver.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ngserver.service.product.Beer;

@RepositoryRestResource
public interface BeerRepository extends JpaRepository<Beer, Long> {
	
	
	@Query("select b from Beer b where b.name = :beerName")
	List<Beer> find(@Param ( "beerName") String beerName) ;
	
}
