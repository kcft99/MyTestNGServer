package com.ngserver.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Pizza extends MenuProduct {

	@OneToOne(cascade = CascadeType.MERGE)
	PizzaBase pizzaBase;

	public PizzaBase getPizzaBase() {
		return pizzaBase;
	}

	public void setPizzaBase(PizzaBase pizzaBase) {
		this.pizzaBase = pizzaBase;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "menuProductId")
	List<Topping> toppings = new ArrayList<Topping>();

	public Pizza() {

	}

	public Double getPrice() {
		price = getPizzaBase().getPrice();
		Stream.of(getToppings().toArray()).forEach(theTopping -> price = price + ((Topping) theTopping).getPrice());

		return price;
	}

	public Pizza(PizzaBase pizzaBase) {
		this.pizzaBase = pizzaBase;
		this.category = pizzaBase.category;
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}

	public String getCategory() {
		return getPizzaBase().getCategory();
	}

	@PrePersist
	@PreUpdate
	private void setTotal() {
		this.price = getPrice();
	}

}
