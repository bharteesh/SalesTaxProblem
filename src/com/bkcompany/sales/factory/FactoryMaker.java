package com.bkcompany.sales.factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bkcompany.sales.Constants;
import com.bkcompany.sales.exception.SalesTaxException;


/**
 * FactoryMaker class which returns Concrete Factory Method based 
 * on the Product type
 * @author bkulkarni
 *
 */
public class FactoryMaker {
	private static ProductFactory productFactory = null;
	
	// Map which holds product type as key and Concrete Product Factory as value
	@SuppressWarnings({ "serial" })
	private static final Map<String,ProductFactory> factoryMap =
		    Collections.unmodifiableMap(new HashMap<String,ProductFactory>() {{
		        put(Constants.BOOK, BookFactory.getInstance());
		        put(Constants.CHOCOLATE, FoodFactory.getInstance());
		        put(Constants.PILLS, MedicalFactory.getInstance());
		        put(Constants.MISC, MiscellaneousFactory.getInstance());
		    }});

	/**
	 * 
	 * @param productType
	 * @return Concrete Product Factory instance for a given product type
	 * @throws SalesTaxException
	 */
	public static ProductFactory getFactory(String productType) throws SalesTaxException{
		productFactory = factoryMap.get(productType);
		if (productFactory == null) {
	        throw new SalesTaxException();
	    }
		return productFactory;
	}
}
