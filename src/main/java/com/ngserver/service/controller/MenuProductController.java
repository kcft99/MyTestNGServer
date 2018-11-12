package com.ngserver.service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ngserver.service.product.MenuProduct;
import com.ngserver.service.repository.MenuProductRepository;

@RestController
public class MenuProductController {

	private final MenuProductRepository menuProductRepository;

	public MenuProductController(MenuProductRepository theRepository) {
		this.menuProductRepository = theRepository;
	}

	public MenuProduct getMenuProduct(Long menuProductId) {
		return this.menuProductRepository.getOne(menuProductId);
	}
}
