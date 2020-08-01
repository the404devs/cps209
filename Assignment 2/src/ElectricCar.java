/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

/*Nothing new in here for Phase 2*/

/*Class ElectricCar is a subclass of Car*/
public class ElectricCar extends Car{
	/*ElectricCar has a couple extra vars a normal Car doesn't,
	such as an integer indicating the charge time,
	and a String indicating the type of battery.*/
	private int rechargeTime = 0;
	private String batteryType = "";
	/*Full disclosure, it seems to me batteryType goes unused, 
	as no values exist in the electric entries in cars.txt, 
	so I just give it a generic value of "Lithium-ion"
	Seems reasonable enough, right?*/

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
		- A bool, indicating whether the car is AWD or not.
		- A String, representing the type of battery. See above note.
		- An int, representing the time taken to charge the battery.*/
	ElectricCar(String mfr, String colour, int power, int numWheels, String model, int maxRange, double safetyRating, double price, boolean AWD, String batteryType, int rechargeTime){
		//Call to Car's constructor with everything we inherit from Car
		super(mfr, colour, power, numWheels, model, maxRange, safetyRating, price, AWD);
		// And then initialize variables unique to ElectricCar
		this.batteryType = batteryType;
		this.rechargeTime = rechargeTime;
	}

	/*Method to display the car's stats.
	Override: Car.display()
	Params: none
	Returns: A string, containing information about the car.*/
	@Override
	public String display(){
		//Same as Car.display(), with the addition of batteryType and rechargeTime in the output
		return super.display() + " " + this.batteryType + " " + this.rechargeTime;
	}
}