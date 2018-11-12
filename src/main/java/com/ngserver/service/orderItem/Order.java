package com.ngserver.service.orderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Table")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long orderId;
	String orderNumber;
	double total;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "orderItemId")
	List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public double getTotal() {
		total = 0.0;
		Stream.of(getOrderItems().toArray()).forEach(theOrderItem ->
			total = total + ((OrderItem) theOrderItem).getTotal()
				);
		
		return total;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Order() {
		
	}
	
	public Order (String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public Order (String orderNumber, List<OrderItem> orderItems) {
		this.orderNumber = orderNumber;
		this.orderItems = orderItems;
	}
	
}
