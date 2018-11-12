package com.ngserver.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngserver.service.product.MenuProduct;

public interface MenuProductRepository extends JpaRepository<MenuProduct, Long> {

}
