/* CPS209 Assignment #1
*  Owen Goodwin
*  500909196
*  03/17/19 */


/* Importing various classes we require
We use an ArrayList to store the Car objects we create from cars.txt
We use Scanner to read the user's input
We use many classes from java.io to read from cars.txt, 
such as File and FileNotFoundException. */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*Main Class of the project*/
public class CarDealershipSimulator{
	/* A static Car object, used to keep track of the last car purchased,
	so we know which car to return. */
	private static Car lastCarBought = null;

	/* Method to end the program. Who says I can't have fun with it? 
	 Called via command Q */
	private static void quit(){
		try{//Try-catch, because we're trying to convince them to switch to Linux...
			if (System.getProperty("os.name").contains("Windows")) {
				System.out.println("Thanks for your time. \n You are currently using Windows, but would you be willing to consider switching to Linux?");
				java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.linuxfoundation.org/"));
			}			
		}catch(Exception e){}
		System.exit(0);//End the program with a normal status code.
	}

	/* Method to create an ArrayList of Car objects from the data in cars.txt
	 Called shortly after the program begins.
	 Parameters: none. 
	 Returns: An ArrayList of Cars, ready to be added to a CarDealership.*/
	private static ArrayList<Car> readCarsFromFile(){
		File f = new File("cars.txt");//Initialize a new File object
		ArrayList<Car> cars = new ArrayList<Car>();//Create an empty ArrayList
		try{//Try-catch block, in case cars.txt does not exist.
			Scanner s = new Scanner(f);//Create a Scanner object from the aforementioned File object.
			String line = s.nextLine();//Read the first line of the file into a String
			while(s.hasNextLine()){	//We're gonna loop through the file line-by-line

				/*I couldn't help but notice that cars.txt had some sketchy-ass whitespace going on,
				 so we use trim() to remove any leading or trailing whitespace,
				 and then call replaceAll(" +"," "), which will replace any amount of spaces, whether that be 1 or 10,
				 with a single space, making my life a lot easier.
				 We then use good old split() to break the string up into an Array at each single space.*/
				String[] arr = line.trim().replaceAll(" +"," ").split(" ");
				//Quick reminder that all of this shenanigans could have been avoided if cars.txt was formatted nicely.

				for (int x = 0; x<arr.length; x++) {//Looping through our newly created Array...
					/* We check if the array contains the keywords for the 2 engine types,
					and replace them with the corresponding integer constant from the Vehicle class. */
					if (arr[x].equals("ELECTRIC_MOTOR")) {
						arr[x] = Vehicle.ELECTRIC_MOTOR +"";
					}
					else if (arr[x].equals("GAS_ENGINE")) {
						arr[x] = Vehicle.GAS_ENGINE +"";
					}
				}

				//With the data in the array, we create a Car object to add to the ArrayList
				if(arr.length>8){
					//If our array is longer than 8, it has the additional information to create an ElectricCar
					cars.add(new ElectricCar(arr[0], arr[1], Integer.parseInt(arr[3]), 4, arr[2], Integer.parseInt(arr[5]), Double.parseDouble(arr[4]), Double.parseDouble(arr[7]), arr[6].equals("AWD"), "Lithium-ion", Integer.parseInt(arr[8])));
				}
				else{
					//Otherwise its a normal car.
					cars.add(new Car(arr[0], arr[1], Integer.parseInt(arr[3]), 4, arr[2], Integer.parseInt(arr[5]), Double.parseDouble(arr[4]), Double.parseDouble(arr[7]), arr[6].equals("AWD")));
				}
				line = s.nextLine();//Get the next line of cars.txt, and repeat!
			}
		}catch(FileNotFoundException e){
			//Some error handling, in case of emergency.
			System.out.println("cars.txt not found. this is entirely your fault.");
		}
		return cars;//Spit out our little ArrayList of cars.
	}

	/* Main function, this is where the fun begins. */
  	public static void main(String[] args){
  		
		// Create a CarDealership object
		CarDealership cd = new CarDealership();
		//Calling readCarsFromFile to get an ArrayList of shiny new cars.
		ArrayList<Car> cars = readCarsFromFile();
		cd.addCars(cars);//Add the cars to the CarDealership, by passing the ArrayList to the function.

		//Simple title output. Normally I'd do some ASCII art, but I got lazy.
		System.out.println("Car Dealership Simulator");

		//Create a new Scanner object, from which we'll get the user's input.
		Scanner scan = new Scanner(System.in);

		//Infinite loop. while(true) is too mainstream.
		while("pigs"!="fly"){
		  	//Some more prompts for the user
		  	System.out.println("");
			System.out.println("Input command... (H for help)");

			//Get the user's input, convert it all to uppercase.
			//This was, BUY and buy are treated equally
		  	String input = scan.nextLine().toUpperCase();

		  	/*Begin long if-else, testing for all possible commands.*/
		  	if (input.equals("L"))
		  		//L: List Inventory
		  		//Simple enough, we call CarDealership's method for that.
		  		cd.displayInventory();
		  	else if (input.equals("Q")){
		  		//Q: Quit
		  		//Self-explanatory.
		  		quit();
		  	}
		  	else if (input.contains("BUY")){
		  		//BUY: Buy a car.
		  		int x;//A new int, which we will use to hold the index of the car the user wants to buy.
		  		try{// Try-catch, to ensure we only process a valid command in the form BUY x.
		  			x=Integer.parseInt(input.substring(4));//Parse the given arg into an integer value.
		  			Car car = cd.buyCar(x);//Call CarDealership's buy method, passing the index of the selected car.
		  			if (car instanceof Car) {//Ensuring that the car is actually car. This prevents us from buying null.
		  				lastCarBought = car;//Update our tracker var.
		  				//Message to tell the user that their purchase was successful
		  				System.out.println("Successfully bought a:");
		  				//We use the car's display method to write out the car's stats.
		  				System.out.println(car.display());
		  			}
		  		}catch(Exception e){//If the command was invalid, scold the user.
		  			System.out.println("Please specify which car you would like to buy.");
		  		}
		  	}
		  	else if (input.equals("RET")){
		  		//RET: Return the last-bought car.
		  		if (lastCarBought instanceof Car) {//Make sure the last car was actually a car.
		  			//Tell the user everything went according to plan
		  			System.out.println("Returned a:");
		  			//Display the stats of the returned car.
			  		System.out.println(lastCarBought.display());
			  		//Actually return the car, using CarDealership's returnCar() method.
			  		cd.returnCar(lastCarBought);
			  		lastCarBought = null;//Clear our tracker var.
		  		}
		  		else{//There is no car to be returned.
		  			System.out.println("No car to return.");
		  		}
		  	}
		  	else if (input.equals("ADD")){
		  		//ADD: Adds more cars to the inventory
		  		System.out.println("Added cars.");
		  		//Uses the Arraylist generated from cars.txt
		  		cd.addCars(cars);
		  	}
		  	//SORT COMMANDS: Sorts the inventory using CarDealership's sort methods.
		  	else if (input.equals("SPR")){
		  		//SPR: Sort by price, cheapest first.
		  		System.out.println("Inventory sorted by price.");
		  		cd.sortByPrice();
		  	}
		  	else if (input.equals("SSR")){
		  		//SSR: Sort by safety rating, highest first.
		  		System.out.println("Inventory sorted by safety rating.");
		  		cd.sortBySafetyRating();
		  	}
		  	else if (input.equals("SMR")){
		  		//SMR: Sort by max range, highest first
		  		System.out.println("Inventory sorted by max range.");
		  		cd.sortByMaxRange();
		  	}
		  	//FILTER COMMANDS: Filters the inventory list, using CarDealership's filter methods.
		  	else if (input.equals("FEL")){
		  		//FEL: Show only electric cars.
		  		System.out.println("Set filter for electric cars.");
		  		cd.setElecFilter(true);
		  	}
		  	else if (input.contains("FPR")){
		  		//FPR: Filter by price, user specifies min and max prices
		  		//Form: FPR min max
		  		try{//Try-catch, because you should never trust a user to do things properly.
		  			//Pull some substring magic to extract the two values from the command
		  			//We use doubles, well, because these are prices.
		  			double min = Double.parseDouble(input.substring(input.indexOf(" "),input.lastIndexOf(" ")));
		  			double max = Double.parseDouble(input.substring(input.lastIndexOf(" ")));
		  			cd.setMinPrice(min);//Set the CarDealership's min and max price values.
		  			cd.setMaxPrice(max);
		  			System.out.println("Set filter for price range $"+min+" - $"+max+".");
			  		cd.setPriceFilter(true);//And finally set the flag for the price filter.
		  		}catch(Exception e){//The user fucked up. I'm not surprised.
		  			System.out.println(e);
		  			System.out.println("Please specify min and max prices");
		  		}
		  	}
		  	else if (input.equals("FAW")){
		  		//FAW: Show only AWD cars.
		  		System.out.println("Set filter for AWD cars.");
		  		cd.setAwdFilter(true);
		  	}
		  	else if (input.equals("FCL")){
		  		//FCL: Remove all active filters. CarDealership has a method for that.
		  		System.out.println("All filters unset.");
		  		cd.clearFilters();
		  	}
		  	else if (input.equals("H")){
		  		//H: Help. Lists information about all the commands.
		  		System.out.println("Avaliable commands:");
		  		System.out.println("-------------------------------");
		  		System.out.println("L: List cars currently in inventory.");
		  		System.out.println("BUY x: Buy car at position x in the inventory.");
		  		System.out.println("RET: Return the last car bought to the inventory.");
		  		System.out.println("ADD: Adds more cars to the inventory.");
		  		System.out.println("SPR: Sort inventory by price, least to greatest.");
		  		System.out.println("SSR: Sort inventory by safety rating, highest to lowest.");
		  		System.out.println("SMR: Sort inventory by max range, highest to lowest.");
		  		System.out.println("FPR x y: Filter inventory by a price range, where x is the minimum price and y is the maximum.");
		  		System.out.println("FEL: Filter inventory, showing only electric vehicles.");
		  		System.out.println("FAW: Filter inventory, showing only AWD vehicles.");
		  		System.out.println("FCL: Clear all active filters.");
		  		System.out.println("H: Show help.");
		  		System.out.println("Q: Quit.");
		  	}
		  	else{
		  		//The user inputted some gibberish we don't understand.
		  		System.out.println("Unrecognized command.");
		  	}
	    } 
    }
}