package com.ngserver.service.product;

public enum ProductCategory {
	FOOD("FD", "food"), DRINK("DK", "drink");

	private String description;
	private String code;

	ProductCategory(String code, String description) {
		this.description = description;
	}

	public String toDescription() {
		return this.description;
	}

	public String toCode() {
		return this.code;
	}

}
