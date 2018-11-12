package com.ngserver.service.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MenuProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected Long menuProductId;
	
	protected String category;
	Double price;

	public Long getMenuProductId() {
		return menuProductId;
	}

	public void setMenuProductId(Long menuProductId) {
		this.menuProductId = menuProductId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
