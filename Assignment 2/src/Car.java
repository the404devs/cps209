/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

/*Nothing new in here for Phase 2*/

/*Class Car is a subclass of Vehicle, and interfaces with Comparable*/
public class Car extends Vehicle implements Comparable{
	String model = "";//To store the model of the Car
	int maxRange = 0;//The max range of the Car
	double safetyRating = 0.0;//The safety rating of the Car
	double price = 0.0;//The price range of the Car
	boolean AWD = false;//Indicated whether or not the Car is all-wheel drive


	/*I was told to create these constants, so I did.
	However, it is my opinion that they are redundant and a waste of memory,
	so here they will sit, unused.
	Why should I check if the model specified in cars.txt is equal to one of 
	these, and then set the car's model to the constant when I could just set 
	it to the value in cars.txt and skip the middleman?*/
	private static final String SEDAN = "SEDAN";
	private static final String SUV = "SUV";
	private static final String SPORTS = "SPORTS";
	private static final String MINIVAN = "MINIVAN";

	/*Default Constructor
	Params:
		- A string representing the manufacturer
		- A string representing the car's colour
		- An integer representing the car's power
		- An integer representing the car's number of wheels (probably 4)
		- A String representing the car's model (sedan, suv, etc.)
		- An integer representing the car's maximum range
		- A double, representing the car's safety rating
		- A double representing the car's price
		- A bool, indicating whether the car is AWD or not.*/
	Car(String mfr, String colour, int power, int numWheels, String model, 
		int maxRange, double safetyRating, double price, boolean AWD){
		//Call to Vehicle's constructor, with the vars we inherit from Vehicle
		super(mfr, colour, power, numWheels);
		//Now set the rest of the variables.
		this.model = model;
		this.maxRange = maxRange;
		this.safetyRating = safetyRating;
		this.price = price;
		this.AWD = AWD;
	}

	/*Method to display the car's stats.
	Override: Vehicle.display()
	Params: none
	Returns: A string, containing information about the car.*/
	@Override
	public String display(){
		/*Construct a string consisting of the output of Vechile.display(),
		in addition to some stats specific to a Car*/
		return super.display() + " " + this.model + " " + this.maxRange + " " + this.safetyRating + " " + this.price + " " + this.AWD;
	}

	/*Method to check if two Cars are equal.
	Overrides: Object.equals()
	Params: An object, presumably of type Car
	Returns: A bool, indicating whether the given Car is equal to this Car*/
	@Override
	public boolean equals (Object obj){
		if (obj instanceof Car) {//Ensure the given object is a Car
			Car other = (Car) obj;//Cast said object to a Car
			if (super.equals(obj) && this.model.equals(other.model) && this.AWD == other.AWD) {
				//Return true if the stats of both Cars are equal
				return true;
			}
			else{
				//Otherwise, they're not equal
				return false;
			}	
		}
		else{//Given object wasn't a Car, how can you expect me to compare the two?
			System.out.println("Given argument is not of type Car");
			return false;
		}
	}

	/*Method to compare two Cars by price.
	This method is used by default when calling Collections.sort() on
	an ArrayList of Cars.
	Params: An object, hopefully a Car object
	Returns: An int. 	
		1 if this car is more expensive
		-1 if the other car is more expensive
		0 if they are the same price */
	public int compareTo(Object obj){
		Car other = (Car) obj;//Cast the object to a Car. 
		if (this.price>other.price) 
			return 1;//Return one if this car is more pricey
		else if (this.price<other.price)
			return -1;//Return -1 if that car is more pricey
		else
			return 0;//Return 0 if they are equally pricey
	}

	/*Access methods for safetyRating and maxRange
	Params: none
	Returns: A double for safetyRating, and an int for maxRange*/
	public double getSafetyRating(){
		return this.safetyRating;
	}
	public int getMaxRange(){
		return this.maxRange;
	}
}