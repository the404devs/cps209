/* CPS209 Assignment #1
*  Owen Goodwin
*  500909196
*  03/17/19 */

import java.util.ArrayList;//Required to store our Car objects.
import java.util.Collections;//Required to sort said Car objects.

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

	//Default constructor, no parameters.
	CarDealership(){
		this.cars = new ArrayList<Car>();//Initialize the dealership with an empty inventory.
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

	/*Method to allow a user to buy a car
	Parameters: An integer, indicating the index of the car in the inventory
	Returns: A Car. More precisely, the one that was purchased.
		Will return null if there is no Car at the given index. */
	public Car buyCar(int i){
		//Attempt to access the Car at the given index.
		try{
			//Great, so the car exists.
			Car toBuy = this.cars.get(i);//Get the Car
			this.cars.remove(i);//Remove it from the dealership's inventory...
			return toBuy;//...and spit it back out to the user.
		}
		catch(IndexOutOfBoundsException e){
			//The car doesn't exist.
			//Maybe we shouldn't have advertised flying cars....
			System.out.println("Car does not exist!");
			return null;//Give the user nothing instead of their dream flying car.
		}
	}

	/* Method to allow a user to return the Car they just bought, 
		because they realized it wasn't a real car.
	Parameters: A Car, stored in CarDealershipSimulator's lastCarBought var.
	Returns: Nothing. */
	public void returnCar(Car car){
		this.cars.add(car);//Add the given Car to our inventory.
	}

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

	/****SORT METTHODS****/
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

