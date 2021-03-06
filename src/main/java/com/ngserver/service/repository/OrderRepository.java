package com.ngserver.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PostMapping;

import com.ngserver.service.orderItem.Order;

@RepositoryRestResource
public interface  OrderRepository extends JpaRepository <Order, Long>  {

}
