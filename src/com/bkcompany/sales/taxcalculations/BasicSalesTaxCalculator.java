package com.bkcompany.sales.taxcalculations;


/**
 * BasicSalesTaxCalculator is a sub-class of SalesTaxCalculator
 * @author bkulkarni
 *
 */
public class BasicSalesTaxCalculator extends SalesTaxCalculator {

	/**
	 * Invokes default constructor of SalesTaxCalculator passing
	 * the parameter: SALESTAX Value
	 */
	public BasicSalesTaxCalculator() {
		super(TaxPercentages.BASICSALESTAX.getValue());
	}

}
