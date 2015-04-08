package com.bkcompany.sales.products;

import java.math.BigDecimal;

/**
 * Medical is a sub-class of Product
 * @author bkulkarni
 *
 */
public class Medical extends Product {

	/**
	 * Constructor to create a new Medical product
	 * which invokes the Product's default constructor
	 * @param name
	 * @param price
	 */
	public Medical(String name, BigDecimal price) {
		super(name, price);
	}
	
	/**
	 * Default Constructor
	 */
	public Medical(){
		
	}


}
