/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

import java.util.Random;//We use Random to create a unique transaction id
import java.util.ArrayList;//Required to store our Transaction objects.
import java.util.Calendar;//Needed for dates
import java.util.GregorianCalendar;//Needed for dates
import java.text.DecimalFormat;//Needed to format decimals.
/*AccountingSystem class
One of these is assigned to each CarDealership object.
Has an ArrayList we fill with all of the dealership's transactions
as well as a double that keeps track of the dealership's balance.*/
public class AccountingSystem{
	ArrayList<Transaction> db = null;//Will hold all Transactions
	double balance = 0;//Keep track of the money we've made. Goes up when we sell, and down when they return.

	public AccountingSystem(){
		this.db = new ArrayList<Transaction>();//Initialize the ArrayList
	}

	/*Method to add a new Transaction to our ArrayList, and return a receipt for the transaction
	Params: A GregorianCalendar obj, so we know when the transaction was made.
			A Car, because that's all we do business with.
			A SalesRep, because someone has to do the dirty work.
			A String type, either BUY or RET. This determines, among other things, how we treat the specified sales rep.
			A double price, because there's gonna be money involved.
	Returns: A String, being the Transaction record*/
	public String add(GregorianCalendar date, Car car, SalesRep salesRep, String type, double price){
		Random r = new Random();//We generate a random transaction ID, between 1 and 99.
		//What happens if we get duplicates? Confusion.
		Transaction t = new Transaction(r.nextInt(99)+1, date, car, salesRep, type, price);//Generate a new transaction object with the given info, and our random ID
		this.db.add(t);//Add the transaction to the ArrayList
		if (type.equals("BUY")) {
			salesRep.sell();//If we've just sold a car, give whoever sold it a pat on the back, and add 1 to their total.
			this.balance+=price;//We just sold a car. Add the car's value to our balance.
		}
		else {
			salesRep.ret();//The customer didn't like what Billy sold them. Billy just lost himself a point.
			this.balance-=price;//The customer returned a car. Take the car's value out of our balance.
			//If we didn't have a return policy, this virtual car dealership wouldn't be losing any money.
		}
		return t.display();//Show the record for the new Transaction
	}

	/*Method to get a specified Transaction
	Params: An integer id. All Transactions have one.
	Returns: The Transaction that corresponds to the id, or null if there is none.*/
	public Transaction getTransaction(int id){
		for (Transaction t : db) {//Check each transaction in our list
			if (t.id == id) //If the transaction ID's match, we've found it
				return t;//Spit it back out
		}
		//Uh-oh. If we've got down here, there is no transaction with the given ID
		System.out.println("Record not found!");
		return null;//So give 'em nothing, cause that's the next best thing
	}

	/*Method to display all Transactions in the history of the CarDealership
	Params: none
	Returns: the vast emptiness of the void*/
	public void displayAll(){
		for (Transaction t : db) {//Go through each transaction in the db
			System.out.println(t.display());//And show it's record
		}
	}

	/*Method to display all Transactions for a specific month
	Params: An int, 1-12, indicating the month to show*/
	public void displayMonth(int m){
		for (Transaction t : db) {//Go through each transaction
			if(t.date.get(Calendar.MONTH)+1==m){//if it took place in the requested month
				System.out.println(t.display());//Show it's record
			}
		}
	}

	/*Method to get the number of cars sold in a particular month
	Params: an integer, 1-12, representing the month
	Returns: an integer, representing the total number of cars sold that month, even ones returned later*/
	public int getMonthSold(int m){
		int i = 0;//Running total
		for (Transaction t : db) {//Loop through all transactions
			if(t.date.get(Calendar.MONTH)+1==m && t.type.equals("BUY")){//if it took place in the requested month, and was a purchase
				i++;//add one to our total
			}
		}
		return i;//return our total
	}

	/*Method to get the number of cars sold in the whole year
	Params: none
	Returns: an integer, representing the total number of cars sold, even ones returned later*/
	public int getYearSold(){
		int i = 0;//running total
		for (Transaction t : db) {//Loop through all transactions
			if(t.type.equals("BUY")){//if it was a purchase
				i++;//add one to our total
			}
		}
		return i;//return our total
	}

	/*Method to get the number of cars returned this year
	Params: none
	Returns: an integer, representing the total number of cars returned*/
	public int getYearRet(){
		int i = 0;//Running total
		for (Transaction t : db) {//Loop through all transactions
			if(t.type.equals("RET")){//if it was a return
				i++;//Add one to the total
			}
		}
		return i;//man this has really been a ctrl+c, ctrl+v workout
	}

	/*Method to get the average sales per month, in $
	Params: none
	Returns: A double, formatted to 2 decimal places as a string*/
	public String getMonthlyAverage(){
		double i = 0;//Running total
		for (Transaction t : db) {//Go through all transactions
			if(t.type.equals("BUY")){//if it was a purchase
				i+=t.price;//add the value of that transaction to our running total
			}
		}
		DecimalFormat d = new DecimalFormat("0.00");//We use one of these bad boys to format our average in 2 decimal places
		return d.format(i/12);//Take the average by dividing by 12, and format it nicely.
	}

	/*Method to get month in which the most cars were sold, including ones later returned
	Params: an integer, 1-12, representing the month
	Returns: an integer, representing the month in which the most cars were sold*/
	public int getHighestSellingMonth(){
		int m = 1;//Month we're looking at currently, our counter var
		int highestMonth = 1;//To hold the highest selling month
		double highestValue = 0;//To hold the number of cars sold in that highest-selling month
		while (m<13) {//Loop through all months
			if (getMonthSold(m)>highestValue) {//Compare the number sold that month to our highest
				highestValue = getMonthSold(m);//Update our values if we've stumbled across a higher-selling month
				highestMonth = m;
			}
			m++;
		}
		return highestMonth;//Return whatever month we've determined to be the highest-selling
	}

	/*Method to show various sales statistics, such as average monthly sales and whatnot
	Params: none
	Returns: nothing*/
	public void showStats(){

		/*Here we simply call the above methods, and present their information in a format that the user can understand*/
		System.out.println("Balance for current year to date: $"+this.balance);
		System.out.println("Total num sold year to date: "+getYearSold());
		int m = 1;
		while(m<13){//Using a while loop to call getMonthSold() for each month (1-12)
			System.out.println("Num sold for month "+m+": "+getMonthSold(m));
			m++;
		}
		System.out.println("Total num returned year to date: "+getYearRet());
		System.out.println("Average monthly sales: $" + getMonthlyAverage());
		System.out.println("Month with highest num sold: "+getHighestSellingMonth());
	}
}