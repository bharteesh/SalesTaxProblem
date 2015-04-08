package com.bkcompany.sales.products;

import java.math.BigDecimal;

/**
 * Abstract class Product containing name of the product and it's price
 * @author bkulkarni
 *
 */
public abstract class Product {
	private String name;
	private BigDecimal price;
	
	public Product(){
		
	}
	
	
	/**
	 * Default constructor to instantiate a Product
	 * @param name
	 * @param price
	 */
	public Product(String name, BigDecimal price){
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
