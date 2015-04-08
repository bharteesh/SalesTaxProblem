package com.bkcompany.sales.factory;

import java.math.BigDecimal;

import com.bkcompany.sales.products.Medical;
import com.bkcompany.sales.products.Product;

/**
 * MedicalFactory class to create a new Medical product
 * @author bkulkarni
 *
 */
public class MedicalFactory extends ProductFactory {

	// Early Instantiation
	private static MedicalFactory medicalFactoryInstance = new MedicalFactory();
	
	/**
	 * Returns ConcreteFactory Singleton instance
	 */
	public static MedicalFactory getInstance(){
		return medicalFactoryInstance;
	}
	
	@Override
	public Product createProduct(String name, BigDecimal price) {
		
		return new Medical(name, price);
		
	}

}
