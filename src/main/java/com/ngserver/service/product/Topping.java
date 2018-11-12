package com.ngserver.service.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topping {
	
	@Id
	@GeneratedValue
	Long toppingId;
	
	Double price;
	
	public Topping() {
	}
	
	public Topping(String name, Double price) {
	     this.name = name;
	     this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	String name;

	public Long getToppingId() {
		return toppingId;
	}

	public void setToppingId(Long toppingId) {
		this.toppingId = toppingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
