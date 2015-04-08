package com.bkcompany.sales.taxcalculations;

import java.math.BigDecimal;

import com.bkcompany.sales.exception.SalesTaxException;


/**
 * Interface for tax calculations
 * @author bkulkarni
 *
 */
public interface ITaxCalculator {
	/**
	 * calculate tax for a given price
	 */
	BigDecimal calculateTax(BigDecimal price) throws SalesTaxException;

}
