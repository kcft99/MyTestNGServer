package com.ngserver.service.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PizzaBase extends MenuProduct{
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	String name;
	Double price;
	
	public PizzaBase() {
		
	}

	public PizzaBase (String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public PizzaBase (String name, Double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
}
