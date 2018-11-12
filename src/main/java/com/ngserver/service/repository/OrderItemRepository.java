package com.ngserver.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ngserver.service.orderItem.OrderItem;

@RepositoryRestResource
public interface  OrderItemRepository extends JpaRepository <OrderItem, Long>  {

}
