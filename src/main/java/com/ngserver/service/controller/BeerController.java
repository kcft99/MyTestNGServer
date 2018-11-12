package com.ngserver.service.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngserver.service.product.Beer;
import com.ngserver.service.repository.BeerRepository;

@RestController
public class BeerController {
	
	private final BeerRepository beerRepository;
	
	public BeerController( BeerRepository theRepository) {
		this.beerRepository = theRepository;
	}
	
	@GetMapping("/getBeers")
	@CrossOrigin
	public List<Beer> getBeers() {
		return beerRepository.findAll();
	}

}
