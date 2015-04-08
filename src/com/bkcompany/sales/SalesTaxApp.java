package com.bkcompany.sales;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.bkcompany.sales.billing.Basket;
import com.bkcompany.sales.exception.SalesTaxException;


/**
 * Main class
 * 	- Calls InputFileReader class to get basket details
 * 	- Checks out the basket
 * @author bkulkarni
 *
 */
public class SalesTaxApp {
	
	public static void main(String args[]){
		FileReader fileReader = null;
		try {
			String file = args[0];
			fileReader = new FileReader(file);
			System.out.println("INPUT");
			InputFileReader inputReader = new InputFileReader(fileReader);
			Basket basket = inputReader.getBasketDetails();
			System.out.println("\nOUTPUT");
			basket.checkout();
		} catch (FileNotFoundException e) {
			System.out.println("Exception occurred while reading the input file: "+e.getMessage());
		} catch (SalesTaxException e) {
			System.out.println("SalesTaxException: "+e.getMessage());
		}
	}
	
}
