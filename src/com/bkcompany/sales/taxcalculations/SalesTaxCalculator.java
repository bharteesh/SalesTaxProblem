package com.bkcompany.sales.taxcalculations;

import java.math.BigDecimal;

import com.bkcompany.sales.exception.SalesTaxException;

/**
 * SalesTaxCalculator is a sub-class of AbstractTaxCalculator
 * @author bkulkarni
 *
 */
public class SalesTaxCalculator extends AbstractTaxCalculator {

	protected final BigDecimal tax;

	public SalesTaxCalculator(final BigDecimal tax) {
		this.tax = tax;
	}

	/** (non-Javadoc)
	 * @see taxcalculations.AbstractTaxCalculator#calculate(java.math.BigDecimal)
	 * Returns the amount calculated after applying tax 
	 */
	@Override
	public BigDecimal calculate(final BigDecimal value) throws SalesTaxException{
		return value.multiply(tax);
	}

}
