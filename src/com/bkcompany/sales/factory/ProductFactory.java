package com.bkcompany.sales.factory;

import java.math.BigDecimal;

import com.bkcompany.sales.products.Product;

/**
 * Abstract Factory class to create a new Product
 * @author bkulkarni
 *
 */
public abstract class ProductFactory {
	
	/**
	 * Sub-classes to provide implementation to create a new Product
	 * @param name
	 * @param price
	 * @return
	 */
	public abstract Product createProduct(String name, BigDecimal price);

}
