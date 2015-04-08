package com.bkcompany.sales.factory;

import java.math.BigDecimal;

import com.bkcompany.sales.products.Miscellaneous;
import com.bkcompany.sales.products.Product;

/**
 * MiscellaneousFactory class to create a new Miscellaneous product
 * @author bkulkarni
 *
 */
public class MiscellaneousFactory extends ProductFactory {

	// Early Instantiation
	private static MiscellaneousFactory miscFactoryInstance = new MiscellaneousFactory();
	
	/**
	 * Returns ConcreteFactory Singleton instance
	 */
	public static MiscellaneousFactory getInstance() {
		return miscFactoryInstance;
	}
	
	@Override
	public Product createProduct(String name, BigDecimal price) {
		
		return new Miscellaneous(name, price);
		
	}

}
