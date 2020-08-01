/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

import java.util.ArrayList;//Required to store our Car objects.
import java.util.Collections;//Required to sort said Car objects.
import java.util.Calendar;//Needed for dates
import java.util.GregorianCalendar;//Needed for dates
import java.util.Random;//Needed for random dates

/*CarDealership Class
One instance of this is created during the course of the simulation.
A CarDealership has an inventory of cars, which can be sorted and 
filtered to show select portions of its inventory.*/
public class CarDealership{
	private ArrayList<Car> cars;//An ArrayList we use as the dealership's inventory.
	private boolean priceFilter = false;//3 Boolean flags used to indicate whether to filter the inventory
	private boolean awdFilter = false;
	private boolean elecFilter = false;
	private double minPrice = 0.0;//Two doubles that work with the priceFilter flag to display cars within a price range.
	private double maxPrice = 0.0;


	/*****PHASE 2*****/
	public SalesTeam st = null;//Every CarDealership needs a sales team
	public AccountingSystem ass = null;//Every CarDealership should probably have an AccountingSystem, but could probably make do without one.... 
	//A slight typo, but the name stuck ¯\_(ツ)_/¯
	/*End Phase 2*/

	//Default constructor, no parameters.
	CarDealership(){
		this.cars = new ArrayList<Car>();//Initialize the dealership with an empty inventory.
		/*PHASE 2*/
		this.st = new SalesTeam();//Initialize our SalesTeam, by grabbing some random people off the street and forcing them to work for us
		this.ass = new AccountingSystem();//Initialize our AccountingSystem. Gotta keep track of our money, so we have excuses ready when these random people start asking for money
		/*End Phase 2*/
	}

	/******* ACCESS METHODS *******/
	/* These are quite self-explanatory. 
	They allow us to retrieve or change the value 
	of the instance variables declared above. */

	/* Getters */
	public boolean getPriceFilter(){
		return this.priceFilter;
	}
	public boolean getAwdFilter(){
		return this.awdFilter;
	}
	public boolean getElecFilter(){
		return this.elecFilter;
	}
	public double getMinPrice(){
		return this.minPrice;
	}
	public double getMaxPrice(){
		return this.maxPrice;
	}

	/* Setters */
	public void setPriceFilter(boolean x){
		this.priceFilter = x;
	}
	public void setAwdFilter(boolean x){
		this.awdFilter = x;
	}
	public void setElecFilter(boolean x){
		this.elecFilter = x;
	}
	public void setMinPrice(double x){
		this.minPrice = x;
	}
	public void setMaxPrice(double x){
		this.maxPrice = x;
	}


	/*Method to add cars to the Dealership's inventory.
	Parameters: An ArrayList of Cars
	Returns: nothing*/
	public void addCars(ArrayList <Car> newCars){
		for (Car car : newCars) {//The lazy man's for loop
			//Take each car in the given ArrayList, and add it to our inventory.
			this.cars.add(car);
		}
	}

	/*PHASE 2 - buyCar() and returnCar()*/

	/*Method to allow a user to buy a car
	Parameters: An integer, indicating the VIN of the car in the inventory
	Returns: String containing the transaction record of the purchase
		Will return null if there is no Car with the given VIN */
	public String buyCar(int VIN){
		int i = 0;//Counter var. 
		for (Car car : this.cars) {//We look through our inventory until we find the car with the correct VIN
			if (car.getVIN()==VIN) {//Check those VINs
				//Once we've found our car...
				this.cars.remove(i);//Grab the car real quick
				SalesRep rep = st.getPerson();//Hey Bob, get over here!
				Random r = new Random();//Praise the RNG gods
				GregorianCalendar gc = new GregorianCalendar();//Calendar object, to store the date of the transaction
				gc.set(Calendar.YEAR,2019);//Year is 2019
				int max = gc.getActualMaximum(Calendar.DAY_OF_YEAR);//Get the highest possible value for day of year (365, sometimes 366)
				int day = r.nextInt(max);// Random number from 1 to 365, or 366
				gc.set(Calendar.DAY_OF_YEAR,day);//Set the date to our randomly selected number
				return ass.add(gc, car, rep, "BUY", car.price);//Add a record of this transaction to our AccountingSystem, spit the receipt back out at the user.
				//Fun fact: I accidentally removed this return statement and spent hours trying to figure out what was causing a ConncurrentModificationException... FML
			}
			i++;//Increase counter, this ain't it chief
		}
		System.out.println("Car does not exist!");//Must more elegant than throwing an exception.
		//We already check if VIN is a valid int prior to calling this method, 
		//and if the VIN is out of range, we can simply treat it the same as an in-range non-existent VIN;
		//as a car we don't have.
		return null;//Come back to the user empty-handed, if we can't find a car with the given VIN, in range or not.
	}

	/* Method to allow a user to return the Car they just bought, 
		because they realized it wasn't a real car.
	Parameters: An int transaction ID number, given to us by the user.
	Returns: Nothing. */
	public void returnCar(int id){
		Random r = new Random();//Who doesn't love RNG?
		Transaction t = ass.getTransaction(id);//Grab the transaction corresponding to the given id
		//Now before y'all start complaining about not checking the id for validity, 
		//let me mention that we check if its a valid int before calling this method,
		//and getTransaction() will handle an id that doesn't exist just fine.

		if (t.type.equals("RET")) {//Check if the transaction we're trying to return is a return transaction
			System.out.println("Can't return that!");//Tell the user they can't return a return
			return;//return
		}

		for (Car car : this.cars) {//Here we loop through our existing inventory
			if (t.car.getVIN()==car.getVIN()) {//We compare the VINs of our inventory to the car the user is attempting to return
				System.out.println("Hey! We have that car already!");//If that car is in our inventory, they're trying to scam us.
				return;//Abort mission
			}
		}

		//Date of the return transaction needs to be after the car was bought, but before the end of the month
		int max = t.date.getActualMaximum(Calendar.DAY_OF_MONTH);//Grab the last day of the month
		int min = t.date.get(Calendar.DAY_OF_MONTH);//Grab the day the car was bought
		int range = max-min;//Calculate our range of valid dates.
		if (range == 0) range = 1;//If the transaction fell on the last day of the month, we'd have a range of 0. For the sake of sanity, we'll make it returned on the same day instead.
		int day = r.nextInt(range)+min;//And just reach in between those two and pull out the first thing you touch
		GregorianCalendar newDay = new GregorianCalendar();//Create a new date object
		newDay.set(Calendar.YEAR,2019);//Year is still 2019
		newDay.set(Calendar.MONTH,t.date.get(Calendar.MONTH));//Month is the same as when the car was bought
		newDay.set(Calendar.DAY_OF_MONTH,day);//Date is whatever we came up with earlier
		System.out.println(ass.add(newDay, t.car, t.rep, "RET", t.price));//Add a record of this transaction to our AccountingSystem, show the receipt
		this.cars.add(t.car);//Put the car back into our inventory
	}

	/*End Phase 2*/

	/****FILTER METHODS****/
	//These methods all set their respective filters to true.

	/* Method to indicate we should only show cars that are AWD
	Params: None
	Returns: Nothing*/
	public void filterByAWD(){
		this.awdFilter = true;
	}

	/* Method to indicate we should only show cars that are electric
	Params: None
	Returns: Nothing*/
	public void filterByElectric(){
		this.elecFilter = true;
	}

	/* Method to indicate we should only show cars that are AWD
	Params: Two doubles, a minimum and maximum price
	Returns: Nothing*/
	public void filterByPrice(double min, double max){
		this.priceFilter = true;
		//In addition to setting the flag, we also set the dealership's min and max prices to the given values
		this.maxPrice = max;
		this.minPrice = min;
	}

	/* Method to unset all filters.
	Params: None
	Returns: Nothing*/
	public void clearFilters(){
		this.priceFilter = false;
		this.awdFilter = false;
		this.elecFilter = false;
	}

	/* Method to display the current inventory
	Params: None
	Returns: Nothing */
	public void displayInventory(){

		//A big ol' if block, checking all possible combination of filters.
		/*Quite repetitive, we determine which filters are active,
		and then call the display() method of each Car that falls under the 
		current set of filters using a foreach loop.
		The last case occurs when no filters are active, displaying all cars in the inventory.*/

		if (this.priceFilter && this.elecFilter && this.awdFilter) {
			//Print all electric awd cars in price range
			for (Car car : this.cars) {
				if (car.price > this.minPrice && car.price <= this.maxPrice && car instanceof ElectricCar && car.AWD) {
					System.out.println(car.display());
				}
			}
		}
		else if (this.priceFilter && this.elecFilter) {
			//Print all electric cars in price range
			for (Car car : this.cars) {
				if (car.price > this.minPrice && car.price <= this.maxPrice && car instanceof ElectricCar) {
					System.out.println(car.display());
				}
			}
		}
		else if (this.priceFilter && this.awdFilter) {
			//Print all awd cars in price range
			for (Car car : this.cars) {
				if (car.price > this.minPrice && car.price <= this.maxPrice && car.AWD) {
					System.out.println(car.display());
				}
			}
		}
		else if (this.elecFilter && this.awdFilter) {
			//Print all electric and awd cars
			for (Car car : this.cars) {
				if (car instanceof ElectricCar && car.AWD) {
					System.out.println(car.display());
				}
			}
		}
		else if (this.elecFilter){
			//Print all electric cars
			for (Car car : this.cars) {
				if (car instanceof ElectricCar) {
					System.out.println(car.display());
				}
			}
		}
		else if (this.awdFilter){
			//Print all AWD cars
			for (Car car : this.cars) {
				if (car.AWD) {
					System.out.println(car.display());
				}
			}
		}
		else if (this.priceFilter){
			//Print all cars in price range
			for (Car car : this.cars) {
				if (car.price > this.minPrice && car.price <= this.maxPrice) {
					System.out.println(car.display());
				}
			}
		}
		else{
			//Show all cars
			for (Car car : this.cars) {
				System.out.println(car.display());
			}
		}
	}

	/****SORT METHODS****/
	/*Using Collections.sort(), we sort the Inventory by price, safety rating, or max range.*/
	/*Params: None
	Returns: None*/

	public void sortByPrice(){
		//Sorting by price, our default method of sorting.
		Collections.sort(this.cars);
	}
	public void sortBySafetyRating(){
		//Sorting by safety rating, using an instance of our SafetyComparator class
		Collections.sort(this.cars, new SafetyComparator());
	}
	public void sortByMaxRange(){
		//Sorting by max range, using an instance of our RangeComparator class		
		Collections.sort(this.cars, new RangeComparator());
	}

}

