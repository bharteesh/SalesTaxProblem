package com.bkcompany.sales.taxcalculations;

/**
 * ImportTaxCalculator is a sub-class of SalesTaxCalculator
 * @author bkulkarni
 *
 */
public class ImportTaxCalculator extends SalesTaxCalculator {

	/**
	 * Invokes default constructor of SalesTaxCalculator passing
	 * the parameter: IMPORTDUTYTAX Value
	 */
	public ImportTaxCalculator() {
		super(TaxPercentages.IMPORTDUTYTAX.getValue());
	}

}
