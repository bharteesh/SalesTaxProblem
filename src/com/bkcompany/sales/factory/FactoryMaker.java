package com.bkcompany.sales.factory;

import com.bkcompany.sales.Constants;


/**
 * FactoryMaker class which returns Concrete Factory Method based 
 * on the Product type
 * @author bkulkarni
 *
 */
public class FactoryMaker {
	private static ProductFactory pf = null;

	public static ProductFactory getFactory(String choice) {
		if (choice.equals(Constants.BOOK)) {
			pf = BookFactory.getInstance();
		} else if (choice.equals(Constants.CHOCOLATE)) {
			pf = FoodFactory.getInstance();
		} else if (choice.equals(Constants.PILLS)) {
			pf = MedicalFactory.getInstance();
		} else if (choice.equals(Constants.MISC)) {
			pf = MiscellaneousFactory.getInstance();
		} else {
			pf = MiscellaneousFactory.getInstance();
		}
		return pf;
	}
}