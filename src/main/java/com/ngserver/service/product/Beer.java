package com.ngserver.service.product;

import javax.persistence.Entity;

@Entity
public class Beer extends MenuProduct{
private String name;
  
	public Beer() {
    }

    public Beer(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Beer(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + menuProductId +
                ", name='" + name + '\'' +
                '}';
    }
}