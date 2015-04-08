package com.bkcompany.sales.factory;

import java.math.BigDecimal;

import com.bkcompany.sales.products.Food;
import com.bkcompany.sales.products.Product;

/**
 * FoodFactory class to create a new Food product
 * @author bkulkarni
 *
 */
public class FoodFactory extends ProductFactory {

	// Early instantiation
	private static FoodFactory foodFactoryInstance = new FoodFactory();
	
	/**
	 * Returns ConcreteFactory Singleton instance
	 */
	public static FoodFactory getInstance(){
		return foodFactoryInstance;
	}
	
	@Override
	public Product createProduct(String name, BigDecimal price) {
		
		return new Food(name, price);
		
	}

}
