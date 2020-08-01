/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

import java.util.GregorianCalendar;//Needed for dates
import java.text.SimpleDateFormat;//Needed for formatted dates

/*Transaction class
These are used to keep track of all BUY and RET events.
They are stored in the dealership's AccountingSystem object.
Every transaction has an ID number corresponding to it.*/
public class Transaction{
	//Everything here is public. Why? To avoid having to write access methods
	public int id = 0;//'Unique' transaction ID, even though we don't check for duplicates.
	public GregorianCalendar date = null;//A transaction usually occurs on some date, right? So let's keep track of it.
	public Car car = null;//We're a car dealership. Let's also keep track of the car this transaction concerns
	public SalesRep rep = null;//The SalesRep performing the transaction. We need to know who did it, so we can punish them later. Or maybe give them something to eat. Depends on the manager's mood, really.
	public String type = "";//The type of transaction, BUY or RET
	public double price = 0;//The amount of money involved in the transaction

	/*Default constructor
	Params:
		- An ID number, randomly generated.
		- A date, also randomly generated, with some logic. See CarDealership's buy() and return() methods
		- A car. Duh.
		- A SalesRep, because there's gotta be someone other than the customer here.
		- A String indicating what type of transaction it is
		- A price. Also duh.*/
	public Transaction(int id, GregorianCalendar date, Car car, SalesRep rep, String type, double price){
		//Initialize all values to the given ones.
		this.id = id;
		this.date = date;
		this.car = car;
		this.rep = rep;
		this.type = type;
		this.price = price;
	}

	/*Method to display the 'receipt' of the transaction
	Params: none
	Returns: A String, containing all of the information for the transaction*/
	public String display(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");//We use a SimpleDateFormat to display the time in a nice format, like 2000/09/07
		/*Return a string showing, in order:
			- The transaction ID
			- The date of the transaction
			- The name of the rep who performed the transaction
			- The type of transaction
			- The price of the car involved.
			- Information about the car: VIN, model, etc*/
		return "#"+this.id+": "+sdf.format(this.date.getTime())+" ("+this.rep.getName()+", "+this.type+", $"+this.price+") ["+this.car.display()+"]";
	}
}
