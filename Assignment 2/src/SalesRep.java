/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */


/*SalesRep class
The assignment said to just use names for each sales rep, but I figured having SalesRep objects
would make it easier to keep track of how many cars each has sold and whatnot.

Now, some people might argue that people are not objects,
but we just pulled these people off the street and forced them to work for us,
and we don't pay them, because that would hurt our bottom line.
That considered, these people are pretty much objects in the eyes of whoever is running the CarDealership.

These guys have a name in the form of a String, and an int to keep track of how many cars they have sold.
Technically, we don't even need a name, because all we care about is them selling cars, but having their name gives off the 
impression that we're running a perfectly normal car dealership and not enslaving poor random people to sell virtual cars*/
public class SalesRep{
	private String name;//Their name
	private int numSold;//How much they've sold.

	/*Default constructor, needs a name*/
	public SalesRep(String name){
		this.name = name;//Yes, we just give them a new name. Their old life is gone, all that matters is selling cars.
		this.numSold = 0;//What? They haven't sold any cars yet? Get to work!
	}

	/*Method to sell a car*/
	public void sell(){
		this.numSold++;//Tally goes up. Who's a good SalesRep?
	}

	/*Method to return a car.*/
	public void ret(){
		this.numSold--;//User returned a previously sold car, so the rep's tally goes down.
	}

	/*Method to get the number of cars the rep has sold.
	Used to determine which ones are keepers and which ones are slacking off
	Returns: an int, the number of cars they've sold this year*/
	public int getNumSold(){
		return this.numSold;
	}

	/*Method to get the arbitrary name we chose for them.
	Returns: A String, the rep's new permanent identity*/
	public String getName(){
		return this.name;
	}
}