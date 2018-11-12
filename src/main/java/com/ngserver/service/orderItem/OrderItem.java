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

import com.ngserver.service.product.Beer;
import com.ngserver.service.product.MenuProduct;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long orderItemId;
	double total = 0.0;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="orderItemId")
	List<MenuProduct> productList = new ArrayList<MenuProduct>();
	
	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public double getTotal() {
		total = 0.0;
		Stream.of(getProductList().toArray()).forEach(theProduct ->

		total = total + ((MenuProduct) theProduct).getPrice()
				);
		
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<MenuProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<MenuProduct> productList) {
		this.productList = productList;
	}
	
	public void addProduct(MenuProduct product) {
		productList.add(product);
	}
	
}
