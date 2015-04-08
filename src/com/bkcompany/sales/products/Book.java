package com.bkcompany.sales.products;

import java.math.BigDecimal;

/**
 * Book is a sub-class of Product
 * @author bkulkarni
 *
 */
public class Book extends Product {
	
	/**
	 * Constructor to create a new Book product
	 * which invokes the Product's default constructor
	 * @param name
	 * @param price
	 */
	public Book(String name, BigDecimal price) {
		super(name, price);
	}
	
	/**
	 * Default constructor
	 */
	public Book() {
		super();
	}

}
