package com.bkcompany.sales.billing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bkcompany.sales.products.Product;
import com.bkcompany.sales.taxcalculations.ITaxCalculator;
import com.bkcompany.sales.taxcalculations.ImportTaxCalculator;
import com.bkcompany.sales.taxcalculations.BasicSalesTaxCalculator;

/**
 * BasketItem class containing
 * 	- Product object (name, price)
 * 	- quantity of the product
 * 	- final selling price of the product
 * 	- final tax amount of the product
 * 	- List of Tax Calculators (Basic Sales, Import duty, etc)
 * @author bkulkarni
 *
 */
public class BasketItem {

	private Product product;
	private Integer quantity;
	private BigDecimal sellingPrice;
	private BigDecimal taxAmount;
	private final List<ITaxCalculator> taxCalculators = new ArrayList<>();
	
	public BasketItem(){
		
	}

	public BasketItem(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}


	/**
	 * Add all taxes for an item which is not exempt from any taxes
	 */
	public BasketItem addAllTaxCalculators() {
		addBasicSalesTaxCalculator();
		addImportTaxCalculator();
		return this;
	}

	/**
	 * Add only Import Duty Tax for an item which requires an import duty tax
	 */
	public BasketItem addImportTaxCalculator() {
		return addTaxCalculator(new ImportTaxCalculator());
	}

	/**
	 * Add only Basic Sales Tax for an item which is eligible for Basic Sales tax
	 */
	public BasketItem addBasicSalesTaxCalculator() {
		return addTaxCalculator(new BasicSalesTaxCalculator());
	}

	/**
	 * Add the tax calculator to list of ITaxCalculator
	 */
	public BasketItem addTaxCalculator(final ITaxCalculator taxCalculator) {
		this.taxCalculators.add(taxCalculator);
		return this;
	}
	
	
	/** 
	 * Returns formatted String to print output for each BasketItem
	 */
	public String printOutput() {		
		return String.format("%d %s: %.2f", this.quantity, this.product.getName(), this.getSellingPrice());
	}	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public List<ITaxCalculator> getTaxCalculators() {
		return taxCalculators;
	}
	

}
