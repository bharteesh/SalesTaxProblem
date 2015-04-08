package com.bkcompany.sales.billing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bkcompany.sales.exception.SalesTaxException;
import com.bkcompany.sales.taxcalculations.ITaxCalculator;

/**
 * Receipt class to generate final Receipt for the 
 * list of BasketItems
 * @author bkulkarni
 *
 */
public class Receipt {
	/** The list of items purchased. */
	private List<BasketItem> itemsList = new ArrayList<>();
	private BigDecimal totalTax = BigDecimal.ZERO;
	private BigDecimal totalAmount = BigDecimal.ZERO; 
	
	/**
	 * Gets the list of purchased items.
	 * 
	 * @return List<BasketItem>
	 */
	public List<BasketItem> getItemsList() {
		return itemsList;
	}

	/**
	 * Sets the list of items purchased.
	 * 
	 * @param itemsList
	 */
	public void setItemsList(List<BasketItem> itemsList) {
		this.itemsList = itemsList;
	}
	
	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * Generates receipt for each Basket
	 * Prints Selling price of each Item
	 * Prints Total Sales Taxes
	 * Prints Total Amount
	 * @throws SalesTaxException 
	 */
	public void generateReceipt() throws SalesTaxException {
		try {
			for (BasketItem item : getItemsList()) {
				BigDecimal taxAmount = BigDecimal.ZERO;
				for (ITaxCalculator taxCalculator : item.getTaxCalculators()) {
					taxAmount = taxAmount.add(taxCalculator.calculateTax(item
							.getProduct().getPrice()));
				}
				BigDecimal qty = new BigDecimal(item.getQuantity());
				item.setSellingPrice(item.getProduct().getPrice().add(taxAmount).multiply(qty));
				item.setTaxAmount(taxAmount.multiply(qty));
				System.out.println( item.printOutput() );
				totalTax = totalTax.add(item.getTaxAmount());
				totalAmount = totalAmount.add(item.getSellingPrice());
			}
			System.out.println("Sales Taxes: " + totalTax);
			System.out.println("Total: " + totalAmount);
		}catch(SalesTaxException se){
			throw se;
		}
	}

}
