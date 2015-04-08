package com.bkcompany.sales.taxcalculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.bkcompany.sales.Constants;
import com.bkcompany.sales.exception.SalesTaxException;

/**
 * Abstract class AbstractTaxCalculator which provides implementation 
 * for interface ITaxCalculator's abstract methods
 * @author bkulkarni
 *
 */
public abstract class AbstractTaxCalculator implements ITaxCalculator {

	/**
	 * Abstract method implemented by sub classes
	 */
	protected abstract BigDecimal calculate(BigDecimal price) throws SalesTaxException;

	
	/** (non-Javadoc)
	 * @see taxcalculations.ITaxCalculator#calculateTax(java.math.BigDecimal)
	 * Calculates Tax amount including rounded amount
	 * calculate(BigDecimal value) method is implemented by sub-classes
	 */
	@Override
	public BigDecimal calculateTax(final BigDecimal value) throws SalesTaxException{
		final BigDecimal tax = calculate(value);
		final BigDecimal rounded = round(tax);
		return rounded;
	}
	
	/**
	 * Returns amount after rounding upto nearest 0.05
	 */
	private BigDecimal round(BigDecimal value) {
		value = new BigDecimal(Math.ceil(value.doubleValue() * Constants.ROUND_FACTOR) / Constants.ROUND_FACTOR);
        value = value.setScale(2, RoundingMode.HALF_UP);
		return value;
	}
}