/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

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

	private static String lastBuyRecord = "";//Holds the transaction record of the last transaction

	/* Method to end the program. Apparently I can't have fun with it :( 
	 Called via command Q */
	private static void quit(){
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

	/*Method to draw ASCII art
	Params: none
	Returns: nothing*/
	private static void art(){
		try{
			Scanner s = new Scanner(new File("art.txt"));
			while(s.hasNextLine()){
				System.out.println(s.nextLine());
			}
		}catch(FileNotFoundException e){
			System.out.println("Car Dealership Simulator");
		}
		
	}

	/* Main function, this is where the fun begins. */
  	public static void main(String[] args){
  		SalesTeam st = new SalesTeam();
		// Create a CarDealership object
		CarDealership cd = new CarDealership();
		//Calling readCarsFromFile to get an ArrayList of shiny new cars.
		ArrayList<Car> cars = readCarsFromFile();
		cd.addCars(cars);//Add the cars to the CarDealership, by passing the ArrayList to the function.

		//Print our title. I actually did ASCII art this time.
		art();		

		//Create a new Scanner object, from which we'll get the user's input.
		Scanner scan = new Scanner(System.in);

		//Infinite loop. while(true) is too mainstream.
		while("php"!="bad"){//gotta make sure the loop is truly infinite. php will never be good
		  	//Some more prompts for the user
		  	System.out.println("");
			System.out.println("Input command... (H for help)");

			//Get the user's input, convert it all to uppercase.
			//This is so 'BUY' and 'buy' are treated equally
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
		  		int x;//A new int, which we will use to hold the VIN of the car the user wants to buy.
		  		try{// Try-catch, to ensure we only process a valid command in the form BUY x.
		  			x=Integer.parseInt(input.substring(4));//Parse the given arg into an integer value.
		  			/*PHASE 2*/
		  			//lastBuyRecord stores the record of the previous transaction
		  			//The name could be slightly misleading.
		  			//Attempt to buy a car, and store the output record string in lastBuyRecord
		  			lastBuyRecord = cd.buyCar(x);
		  			//buyCar() returns null if there is no car with VIN x
		  			if (lastBuyRecord!=null) {
		  				//by checking for null, we make sure we don't proclaim the success of the purchase at the wrong time
		  				System.out.println("Success!");
		  				System.out.println(lastBuyRecord);//Show the transaction record
		  			}	
		  			/*End Phase 2*/	  			
		  		}catch(NumberFormatException e){//If the command was invalid, scold the user.
		  			// System.out.println(e);
		  			System.out.println("Please specify which car you would like to buy.");
		  		}
		  	}
		  	else if (input.contains("RET")){
		  		//RET: Return the last-bought car.
		  		/*PHASE 2*/
		  		//Ret now works like buy, requiring an integer value as a param.
		  		try{//Try-catch, used to validate input
		  			int id = Integer.parseInt(input.substring(input.indexOf(" ")+1));//Grab the argument
		  			cd.returnCar(id);//And return the car. Simple as that!
		  			//returnCar() will inform the user if the transaction record doesn't exist
		  		}catch(Exception e){
		  			System.out.println("Please specify a valid transaction ID!");//They didn't give us a valid ID. Oops.
		  		}
		  		/*End Phase 2*/
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
		  		/*PHASE 2*/
		  		//Added entries for the SALES commands
		  		/*End Phase 2*/
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
		  		System.out.println("SALES: Show all transactions for the current year.");
		  		System.out.println("SALES TEAM: Show names of all sales representatives.");
		  		System.out.println("SALES TOPSP: Show the name(s) of the sales rep that has sold the most cars this year.");
		  		System.out.println("SALES x: Show all transactions for month x (1-12)");
		  		System.out.println("CUT: Fire the sales rep with the lowest performance.");

		  		System.out.println("H: Show help.");
		  		System.out.println("Q: Quit.");
		  	}
		  	/*PHASE 2*/
		  	else if (input.equals("SALES")){
		  		//SALES: display all transaction records for 2019
		  		cd.ass.displayAll();
		  	}
		  	else if (input.equals("SALES TEAM")){
		  		//SALES TEAM: display names of all sales employees
		  		System.out.println(cd.st.displayTeam());
		  	}
			else if (input.equals("SALES TOPSP")){
		  		//SALES TOPSP: display the name(s) of the employee(s) who sold the most so far this year
		  		System.out.println(cd.st.getTopSeller());
		  	}
		  	else if (input.equals("SALES STATS")){
		  		//SALES STATS: show statistics
		  		cd.ass.showStats();
		  	}
		  	else if (input.contains("SALES")){
		  		//SALES x: Display all transaction records for month x, where x is an int from 1-12.
		  		int x;//Initialize our int, which will hold the given arg
		  		try{
		  			x=Integer.parseInt(input.substring(6));//Parse the given arg into an integer value.
		  			if (x<1||x>12) {//Ensure x is within the correct range
		  				System.out.println("Please enter a value between 1 and 12!");//bad user
		  			}
		  			else{//x is within the correct range
		  				System.out.println("Sales for month "+x+":");
		  				cd.ass.displayMonth(x);//We're just pulling these records out of our... 
		  				//All transaction records will be listed line by line following the call to displayMonth()
		  			}
		  		}
		  		catch(Exception e){//Bad argument, bad user.
		  			System.out.println("Please enter a value between 1 and 12!");
		  		}
		  	}
		  	else if (input.equals("CUT")){
		  		//CUT: Fire an underperforming SalesRep
		  		SalesRep pinkSlip = cd.st.getBottomSeller();//Find whoever has sold the least cars so far
		  		cd.st.fire(pinkSlip);//bye bye
		  	}
		  	/*End Phase 2*/
		  	else{
		  		//The user inputted some gibberish we don't understand.
		  		System.out.println("Unrecognized command.");
		  	}
	    } 
    }
}