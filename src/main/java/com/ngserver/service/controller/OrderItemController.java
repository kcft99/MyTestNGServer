package com.ngserver.service.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngserver.service.orderItem.Order;
import com.ngserver.service.orderItem.OrderItem;
import com.ngserver.service.repository.OrderItemRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
public class OrderItemController {
	
	private final OrderItemRepository orderItemRepository;
	
	public OrderItemController( OrderItemRepository theRepository) {
		this.orderItemRepository = theRepository;
	}
	
	@GetMapping("/getOrderItems")
	@CrossOrigin
	public List<OrderItem> getOrderItems() {
		List<OrderItem> orderItemList = orderItemRepository.findAll();
		return orderItemList;
	}

}
