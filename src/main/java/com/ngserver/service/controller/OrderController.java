package com.ngserver.service.controller;


import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngserver.service.orderItem.Order;
import com.ngserver.service.orderItem.OrderItem;
import com.ngserver.service.product.MenuProduct;
import com.ngserver.service.repository.MenuProductRepository;
import com.ngserver.service.repository.OrderRepository;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin
public class OrderController {
	private final OrderRepository orderRepository;
	private final MenuProductRepository menuProductRepository;
	private SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD");

	public OrderController(OrderRepository orderRepository, MenuProductRepository menuProductRepository) {
		this.orderRepository = orderRepository;
		this.menuProductRepository = menuProductRepository;
	}

	@PostMapping("/addOrder")
	public int addOrder(@RequestBody JSONObject inOrder) {
		System.out.println(inOrder.toString());

		Order newOrder = new Order("2018-" + sdf.format(new Date()) + "-1");
		List<OrderItem> newOrderItemList = newOrder.getOrderItems();
		for (Object menuProductId : ((Collection) inOrder.get("menuProductIds")).toArray()) {
			OrderItem orderItem = new OrderItem();
			MenuProduct theorderProduct = menuProductRepository.getOne(new Long((String) menuProductId));
			orderItem.addProduct(theorderProduct);
			newOrderItemList.add(orderItem);
		}
		this.orderRepository.save(newOrder);
		return 1;
	}
}
