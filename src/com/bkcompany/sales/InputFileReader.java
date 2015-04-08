package com.bkcompany.sales;

import java.io.Reader;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bkcompany.sales.billing.Basket;
import com.bkcompany.sales.billing.BasketItem;
import com.bkcompany.sales.factory.FactoryMaker;
import com.bkcompany.sales.products.Product;

/**
 * InputFileReader class to read the input file
 * 	- creates new Product objects from factory and
 * 	- returns Basket details
 * @author bkulkarni
 *
 */
public class InputFileReader {
	
	private Reader reader;
	
	

	public InputFileReader(Reader reader) {
		super();
		this.reader = reader;
	}
	
	/**
	 * Add products to Basket
	 * @return Basket details to client
	 */
	public Basket getBasketDetails(){
		Scanner scanner = new Scanner(reader);
		scanner.useDelimiter("\n");
		Basket basket = new Basket();
		Pattern pattern = Pattern
				.compile("(\\d+)\\s([\\w\\s]+)\\s([0-9]*\\.?[0-9]+)");
		while (scanner.hasNext()) {
			String nextLine = scanner.next().trim();
			System.out.println(nextLine);
			Matcher matcher = pattern.matcher(nextLine);
			matcher.find();
			if (validProductDescription(matcher)) {
				String quantity = matcher.group(1);
				String description = matcher.group(2);
				String basePrice = matcher.group(3);
				basket.add(createProduct(description, basePrice, quantity));
			}
		}
		scanner.close();
		return basket;
	}

	/**
	 * Creates new products from factory
	 * 	- also adds TaxCalculator based on the type of Product at Run-time
	 * @param description
	 * @param basePrice
	 * @param quantity
	 * @return
	 */
	private BasketItem createProduct(String description, String basePrice, String quantity) {
		
		if(description.toLowerCase().contains(Constants.BOOK)){
			Product p = FactoryMaker.getFactory(Constants.BOOK).createProduct(description, new BigDecimal(basePrice));
			return new BasketItem(p, Integer.valueOf(quantity)); 
		}
		
		if(description.toLowerCase().contains(Constants.CHOCOLATE)){
			Product p = FactoryMaker.getFactory(Constants.CHOCOLATE).createProduct(description, new BigDecimal(basePrice));
			if(description.toLowerCase().contains(Constants.IMPORTED)){
				return new BasketItem(p, Integer.valueOf(quantity)).addImportTaxCalculator(); 
			}
			return new BasketItem(p, Integer.valueOf(quantity)); 
		}
		
		if(description.toLowerCase().contains(Constants.PILLS)){
			Product p = FactoryMaker.getFactory(Constants.PILLS).createProduct(description, new BigDecimal(basePrice));
			return new BasketItem(p, Integer.valueOf(quantity)); 
		}
		
		if(description.toLowerCase().contains(Constants.MUSIC) || description.toLowerCase().contains(Constants.PERFUME)){
			Product p = FactoryMaker.getFactory(Constants.MISC).createProduct(description, new BigDecimal(basePrice));
			if(description.toLowerCase().contains(Constants.IMPORTED)){
				return new BasketItem(p, Integer.valueOf(quantity)).addAllTaxCalculators(); 
			}
			return new BasketItem(p, Integer.valueOf(quantity)).addBasicSalesTaxCalculator(); 
		}
		/*
		 * Added this for safety : to avoid null pointer exceptions
		 */
		Product p = FactoryMaker.getFactory(Constants.MISC).createProduct(description, new BigDecimal(basePrice));
		return new BasketItem(p, Integer.valueOf(quantity)).addBasicSalesTaxCalculator(); 
	}
	
	/**
	 * Checks for valid Product description
	 * @param matcher
	 * @return
	 */
	private boolean validProductDescription(Matcher matcher) {
		return matcher.matches() && matcher.groupCount() == 3;
	}
	
}
