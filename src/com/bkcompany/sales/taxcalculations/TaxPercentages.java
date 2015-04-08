package com.bkcompany.sales.taxcalculations;

import java.math.BigDecimal;


/**
 * Enum class containing TAX Values
 * @author bkulkarni
 *
 */
public enum TaxPercentages {
	NOTAX(new BigDecimal(0)),
	BASICSALESTAX(new BigDecimal(0.10)),
	IMPORTDUTYTAX(new BigDecimal(0.05))
	;
	private final BigDecimal taxValue;

	private TaxPercentages(BigDecimal bd) {
		taxValue = bd;
	}

	public BigDecimal getValue() {
		return taxValue;
	}
}
