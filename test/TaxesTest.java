import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.bkcompany.sales.products.Book;
import com.bkcompany.sales.products.Food;
import com.bkcompany.sales.products.Medical;
import com.bkcompany.sales.products.Miscellaneous;
import com.bkcompany.sales.products.Product;
import com.bkcompany.sales.billing.Basket;
import com.bkcompany.sales.billing.BasketItem;
import com.bkcompany.sales.billing.Receipt;
import com.bkcompany.sales.exception.SalesTaxException;


public class TaxesTest {
	Basket basket1 = new Basket();
	Basket basket2 = new Basket();
	Basket basket3 = new Basket();
	
	@Before
	public void setupBasket1(){

		Product book = new Book("book", new BigDecimal("12.49"));
		Product musicCd = new Miscellaneous("music CD", new BigDecimal("14.99"));
		Product chocobar = new Food("chocolate bar", new BigDecimal("0.85"));
		
	    basket1.add(new BasketItem(book, 1));
	    basket1.add(new BasketItem(musicCd, 1).addBasicSalesTaxCalculator());
	    basket1.add(new BasketItem(chocobar, 1));
	}
	
	@Before
	public void setupBasket2(){

		Product importedChocolates = new Food("imported box of chocolates", new BigDecimal("10.00"));
		Product importedPerfume = new Miscellaneous("imported bottle of perfume", new BigDecimal("47.50"));

		basket2.add(new BasketItem(importedChocolates, 1).addImportTaxCalculator());
		basket2.add(new BasketItem(importedPerfume, 1).addAllTaxCalculators());
	}
	
	@Before
	public void setupBasket3(){

		Product importedPerfume = new Miscellaneous("imported bottle of perfume", new BigDecimal("27.99"));
		Product perfume = new Miscellaneous("bottle of perfume", new BigDecimal("18.99"));
		Product headachePills = new Medical("packet of headache pills", new BigDecimal("9.75"));
	    Product importedChocolates = new Food("imported box of chocolates", new BigDecimal("11.25"));

	    basket3.add(new BasketItem(importedPerfume, 1).addAllTaxCalculators());
		basket3.add(new BasketItem(perfume, 1).addBasicSalesTaxCalculator());
		basket3.add(new BasketItem(headachePills, 1));
		basket3.add(new BasketItem(importedChocolates,1).addImportTaxCalculator());
	}

	@Test
	public void testBasket1() throws SalesTaxException {
		assertEquals("Basket size", 3, basket1.getItemsList().size());
		Receipt receipt = new Receipt();
		receipt.setItemsList(basket1.getItemsList());
		receipt.generateReceipt();
		assertEquals("Total sales tax for all items. ", new BigDecimal("1.50"), receipt.getTotalTax());
		assertEquals("Total Amount for all items. ", new BigDecimal("29.83"), receipt.getTotalAmount());
	}
	
	@Test
	public void testBasket2() throws SalesTaxException {
		assertEquals("Basket size", 2, basket2.getItemsList().size());
		Receipt receipt = new Receipt();
		receipt.setItemsList(basket2.getItemsList());
		receipt.generateReceipt();
		assertEquals("Total sales tax for all items. ", new BigDecimal("7.65"), receipt.getTotalTax());
		assertEquals("Total Amount for all items. ", new BigDecimal("65.15"), receipt.getTotalAmount());
	}
	
	@Test
	public void testBasket3() throws SalesTaxException {
		assertEquals("Basket size", 4, basket3.getItemsList().size());
		Receipt receipt = new Receipt();
		receipt.setItemsList(basket3.getItemsList());
		receipt.generateReceipt();
		assertEquals("Total sales tax for all items. ", new BigDecimal("6.70"), receipt.getTotalTax());
		assertEquals("Total Amount for all items. ", new BigDecimal("74.68"), receipt.getTotalAmount());
	}

}
