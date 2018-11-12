package com.ngserver.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ngserver.service.orderItem.Order;
import com.ngserver.service.orderItem.OrderItem;
import com.ngserver.service.product.Beer;
import com.ngserver.service.product.Pizza;
import com.ngserver.service.product.PizzaBase;
import com.ngserver.service.product.ProductCategory;
import com.ngserver.service.product.Topping;
import com.ngserver.service.repository.BeerRepository;
import com.ngserver.service.repository.OrderRepository;
import com.ngserver.service.repository.PizzaBaseRepository;
import com.ngserver.service.repository.PizzaRepository;
import com.ngserver.service.repository.ToppingRepository;

@Component
public class ApplicationCommandLineRunner implements CommandLineRunner {

	private final BeerRepository beerRepository;
	private final OrderRepository orderRepository;
	private final PizzaBaseRepository pizzaBaseRepository;
	private final ToppingRepository toppingRepository;
	private final PizzaRepository pizzaRepository;
	
		
	public ApplicationCommandLineRunner (BeerRepository theBeerRepository, OrderRepository theOrderRepository, 
			PizzaBaseRepository thePizzaBaseRepository, PizzaRepository thePizzaRepository,
			ToppingRepository theToppingRepository) {
		this.beerRepository = theBeerRepository;
		this.orderRepository = theOrderRepository;
		this.pizzaBaseRepository = thePizzaBaseRepository;
		this.pizzaRepository = thePizzaRepository;
		this.toppingRepository = theToppingRepository;
	}
	
	
	public void run(java.lang.String... args) throws Exception{
		//create beer, pizza
		List<Beer> beerList = new ArrayList<Beer>();
		beerList.add(new Beer("Coors",4.99,"Drink"));
		beerList.add(new Beer("Budwiser",5.99,"Drink"));
		beerList.add(new Beer("Heineken",7.99,"Drink"));
		beerList.add(new Beer("Blue",4.99,"Drink"));
		
		Stream.of(beerList ).forEach( beer ->
		beerRepository.save(beer)
				);
		beerRepository.findAll().forEach( System.out::print);
		
		List<PizzaBase> pizzaList = new ArrayList<PizzaBase>();
		pizzaList.add(new PizzaBase("Basic", 5.99, ProductCategory.FOOD.toCode()));
		pizzaList.add(new PizzaBase("Delux",8.99,"Food"));
		pizzaList.add(new PizzaBase("Thin",7.99,"Food"));
		
		Stream.of(pizzaList).forEach( pizza ->
			pizzaBaseRepository.save(pizza)
				);
		//create orders
		
		Order newOrder = new Order("2018-0926-1");
		List<OrderItem> newOrderItemList = newOrder.getOrderItems();
		
		List<Beer> fBeerList = beerRepository.find("Coors");
		OrderItem orderItem = new OrderItem ();
		orderItem.addProduct(fBeerList.get(0));	
		System.out.println(fBeerList.get(0).getName());
		fBeerList = beerRepository.find("Budwiser");
		System.out.println(fBeerList.get(0).getName());
		orderItem.addProduct(fBeerList.get(0));	
		newOrderItemList.add(orderItem);
		
		orderRepository.save(newOrder);
		
		
		Order newOrder2 = new Order("2018-0926-2");
		List<OrderItem> newOrderItemList2 = newOrder2.getOrderItems();
		
		List<Beer> fBeerList2 = beerRepository.find("Heineken");
		OrderItem orderItem2 = new OrderItem ();
		orderItem2.addProduct(fBeerList2.get(0));	
		System.out.println(fBeerList2.get(0).getName());
		fBeerList2 = beerRepository.find("Budwiser");
		System.out.println(fBeerList2.get(0).getName());
		orderItem2.addProduct(fBeerList2.get(0));	
		newOrderItemList2.add(orderItem2);
		
		orderRepository.save(newOrder2);
		
		Order newOrder3 = new Order("2018-1004-1");
		List<OrderItem> newOrderItemList3 = newOrder3.getOrderItems();
		
		List<PizzaBase> pizzaBaseList1 = pizzaBaseRepository.find("Thin");
		Pizza pizza1 = new Pizza(pizzaBaseList1.get(0));
		
		List<Topping> toppingList1 = toppingRepository.find("PineApple");
		List<Topping> pizzaToppinglist1 = pizza1.getToppings();
		pizzaToppinglist1.add(toppingList1.get(0));
		toppingList1 = toppingRepository.find("Tomato");
		pizzaToppinglist1.add(toppingList1.get(0));
		pizzaRepository.save(pizza1);
		OrderItem orderItem3 = new OrderItem ();
		orderItem3.addProduct(pizza1);	
		System.out.println(pizza1.getPizzaBase().getName());
		newOrderItemList3.add(orderItem3);
		
		orderRepository.save(newOrder3);
		
		
		 
	}
	
}
