package com.bkcompany.sales.products;

import java.math.BigDecimal;

/**
 * Food is a sub-class of Product
 * @author bkulkarni
 *
 */
public class Food extends Product {

	/**
	 * constructor to create a new Food product
	 * which invokes the Product's default constructor
	 * @param name
	 * @param price
	 */
	public Food(String name, BigDecimal price) {
		super(name, price);
	}

	/**
	 * Default constructor
	 */
	public Food(){
		
	}
	

}
