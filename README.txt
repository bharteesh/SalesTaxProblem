SALES TAX PROBLEM


Classes Used:

Product				- 	Abstract class with properties name and price 
						(quantity property included as part of BasketItem)
Concrete Products	- 	Book, Food, Medical, Miscellaneous

ProductFactory		- 	Abstract Factory class which creates new Product - 
						Implementation provided in concrete Factory methods
						
Concrete ProductFactory	- BookFactory,FoodFactory,MedicalFactory,
 						MiscellaneousFactory

FactoryMaker		- 	Returns Concrete Product Factory object at run-time

ITaxCalculator		- 	Interface to calculate tax amount

AbstractTaxCalculator - Abstract class provides implementation to calculate tax 
						amount including rounding upto nearest 5 cents.
							
SalesTaxCalculator		- 	Directly extends AbstractTaxCalculator and provides 
							implementation to calculate the tax amount.
							
BasicSalesTaxCalculator	- 	Extends SalesTaxCalculator to pass just the BASICSALESTAX value to the super class constructor.
							 
ImportTaxCalculator	-   Extends SalesTaxCalculator to pass just the IMPORTDUTYTAX value to the super class constructor.

TaxPercentages		- Enum class containing various tax values (Basic sales tax, Import duty tax)

BasketItem			-	Composed of Product object, quantity, final Selling price of 
						the item, final tax amount and applicable TaxCalculators
						
Basket				- 	Composed of list of BasketItem objects and checkout() method which invokes generateReceipt() on Receipt object.

Receipt				- 	Provides implementation for generating final receipt with total sales tax and total amount.

InputFileReader		- 	Scans through the input file, creates Product objects and returns Basket object (containing BasketItem objects with 
								corresponding TaxCalculators based on the type of Product) to the client (SalesTaxApp).
								
Constants			- 	Includes Constants used in the application

SalesTaxException	- 	Custom Exception class

SalesTaxApp 		- 	Main class which accepts one argument which would be an input file containing list of items with quantity and price.
						Calls checkout() method on Basket object.
						
Design Patterns used:
	a) Singleton 	- 	Used to return a single instance of Concrete Product Factory object to create Product objects.
	b) Abstract Factory Method - FactoryMaker class returns Concrete Product Factory objects at run-time which are responsible for creating
					 			Product objects.
	c) Template		- 	AbstractTaxCalculator defines abstract primitive operations that concrete subclasses define to implement steps of an
					 	algorithm (calculate() method implemented by sub-classes).
	
Object Oriented design aspects:
	a) Inheritance 			-	Inheritance has been widely used in this application. 
								For e.g.: Book, Food, Medical and Miscellaneous classes extend Product class.
	b) Encapsulation		- 	Variables and Methods have been carefully designed to protect data and behavior by applying private, 
								protected and public modifiers.
	c) Polymorphism			- 	When creating new BasketItem objects, eligible tax calculators are also associated with the Product. So, the
								 method which calculates tax is determined at runtime.
	b) Abstraction			- 	Interfaces and Abstract classes have been used to provide Abstraction - concrete implementation is provided
								 by sub-classes.
	e) Follows Open-Closed principle - Open for extension and Closed for modifications.

Configurable:	
	a) Any new TaxCalculator can be easily configurable by extending either SalesTaxCalculator or AbstractTaxCalculator
	b) New Products can be easily added by extending Product and ProductFactory classes
	c) Input data is not hardcoded. Instead, input files have been provided to easily change the data and run the app.
	

How to run the application?

	a) Unzip SalesTaxProblem.zip file
		-- From the terminal, navigate to SalesTaxProblem directory and run the command: ant
			which would compile the source files, reads 3 input files (which contains 3 different Shopping basket details) 
			from "SalesTaxProblem/input" directory and generates output. Test cases would be executed as well.
			(OR)
		-- Import Project in Eclipse and run the Ant build file : build.xml
	
Improvisations
	a) More test cases could have been created
	b) XML could have been used for Input data