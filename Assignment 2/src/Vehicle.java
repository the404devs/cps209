/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

import java.util.Random;//We use Random to create a unique VIN

/* Class Vehicle 
A generic class, from which Car and ElectricCar are derived.*/
public class Vehicle{
	private String mfr = "";//Manufacturer of the vehicle
	private String colour = "";//Colour of the vehicle
	private int power = 0;//Vehicle's power level. I bet it's over 9000.
	private int numWheels = 0;//Number of wheels on the vehicle.
	//Constants representing the two types of engines, gas and electric
	public static final int ELECTRIC_MOTOR = 0;
	public static final int GAS_ENGINE = 1;

	/*****PHASE 2*****/
	private int VIN = 0;//Vehicle ID number, unique to each vehicle.
	/*End Phase 2*/
	
	/*Default Constructor
	Params:
		- A string representing the manufacturer
		- A string representing the car's colour
		- An integer representing the car's power
		- An integer representing the car's number of wheels (probably 4)*/
	Vehicle(String mfr, String colour, int power, int numWheels){
		// Initialize the variables of the Vehicle object.
		this.mfr = mfr;
		this.colour = colour;
		this.power = power;
		this.numWheels = numWheels;
		Random r = new Random();
		this.VIN = r.nextInt(400)+100;//Generate a random int, between 0-399. Add 100 to get the desired range of 100-499.
	}

	/*Method to check if two Vehicles are equal.
	Overrides: Object.equals()
	Params: An object, presumably of type Vehicle
	Returns: A bool, indicating whether the given Vehicle is equal to this Vehicle*/
	@Override
	public boolean equals(Object obj){
		if (obj instanceof Vehicle) {//Ensure we've got a vehicle, and not, say, a pogo stick
			Vehicle other = (Vehicle) obj;//Cast the given object to a vehicle, now that we've determined it is safe to do so
			if (this.mfr.equals(other.mfr) && this.colour.equals(other.colour) && this.power==other.power && this.numWheels == other.numWheels) {
				// Compare the stats of the two vehicles to see if the vehicles are the same
				return true;
			}
			else{
				return false;
			}	
		}
		else{//Goddamn it Karen, how many times do I have to tell you a pogo stick is not a vehicle?
			System.out.println("Given argument is not of type Vehicle");
			return false;
		}			
	}

	/*Method to display stats about the vehicle
	Params: none
	Returns: A string containing the VIN the manufacturer and color of the vehicle*/
	public String display(){
		return this.VIN+" "+this.mfr+" "+this.colour;
	}

	public int getVIN(){
		return this.VIN;
	}
}