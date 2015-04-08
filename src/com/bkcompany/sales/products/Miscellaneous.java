package com.bkcompany.sales.products;

import java.math.BigDecimal;

/**
 * Miscellaneous is a sub-class of Product
 * @author bkulkarni
 *
 */
public class Miscellaneous extends Product {

	/**
	 * Constructor to create a new Miscellaneous product
	 * which invokes the Product's default constructor
	 * @param name
	 * @param price
	 */
	public Miscellaneous(String name, BigDecimal price) {
		super(name, price);
	}
	
	/**
	 * Default constructor
	 */
	public Miscellaneous() {
		
	}


}
