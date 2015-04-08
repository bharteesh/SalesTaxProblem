package com.bkcompany.sales.factory;

import java.math.BigDecimal;

import com.bkcompany.sales.products.Book;
import com.bkcompany.sales.products.Product;


/**
 * BookFactory class to create a new Book product
 * @author bkulkarni
 *
 */
public class BookFactory extends ProductFactory {

	// Early Instantiation
	private static BookFactory bookFactoryInstance = new BookFactory();

	/**
	 * Returns ConcreteFactory Singleton instance
	 */
	public static BookFactory getInstance(){
		return bookFactoryInstance;
	}
	
	/**
	 * Returns a new Book Product
	 */
	@Override
	public Product createProduct(String name, BigDecimal price) {
		
		return new Book(name, price);
		
	}

}
