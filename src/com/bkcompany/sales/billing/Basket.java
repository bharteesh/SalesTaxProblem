package com.bkcompany.sales.billing;

import java.util.ArrayList;
import java.util.List;

import com.bkcompany.sales.exception.SalesTaxException;


/**
 * Basket class containing list of BasketItems
 * @author bkulkarni
 *
 */
public class Basket {
	
	/** The list of BasketItem purchased. */
	private List<BasketItem> itemsList = new ArrayList<>();

	/** Adds an item to list of BasketItems */
	public void add(final BasketItem item) {
		itemsList.add(item);
	}

	/**
	 * Gets the list of purchased items.
	 * 
	 * @return List<BasketItem>
	 */
	public List<BasketItem> getItemsList() {
		return itemsList;
	}
	

	/** 
	 *  Creates a Receipt object and generates final Receipt 
	 *  for the list of BasketItems 
	 * @throws SalesTaxException 
	 */
	public void checkout() throws SalesTaxException {
		Receipt receipt = new Receipt();
		receipt.setItemsList(getItemsList());
		receipt.generateReceipt();
	}

}
