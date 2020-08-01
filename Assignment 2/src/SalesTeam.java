/* CPS209 Assignment #2
*  Owen Goodwin
*  500909196
*  04/10/19 */

import java.util.Random;//We use Random to get a random person from the team
import java.util.*;//For LinkedList

/*SalesTeam class
One of these for every CarDealership object
Has a LinkedList of SalesReps. That sounds painful.
At this point, you've probably noticed this car dealership doesn't have a great deal of respect for it's workers.*/
public class SalesTeam{
	private LinkedList<SalesRep> team;//We keep our sales reps in here. Don't let them escape!

	/*Default Constructor, no params*/
	public SalesTeam(){
		this.team = new LinkedList<SalesRep>();//Initialize our employee-containment device
		//Pull a couple of people off the street, and give them new names.
		//They will be known by these new names for as long as they are with us.
		this.team.add(new SalesRep("Bob"));
		this.team.add(new SalesRep("Bob2"));
		this.team.add(new SalesRep("Bob3"));
		this.team.add(new SalesRep("Bob4"));
		this.team.add(new SalesRep("Bob5"));
		this.team.add(new SalesRep("Bob6"));
	}

	/*Method to get a random SalesRep, to interact with the customer during a transaction
	Params: none
	Returns: A SalesRep object*/
	public SalesRep getPerson(){
		Random r = new Random();//New random obj
		return this.team.get(r.nextInt(team.size()));//Grab a random SalesRep obj, using the size of the team to generate that random value
	}

	/*Method to show the names of all our SalesReps, because we never bother to learn them
	Params: none
	Returns: A String containing a comma-separated list of the names of our SalesReps*/
	public String displayTeam(){
		ListIterator<SalesRep> iterator = this.team.listIterator();//Create a new iterator
		String out = "Sales Team: ";//Begin our output string
		while(iterator.hasNext()){//Iterate through our LinkedList of employees
			out += iterator.next().getName()+", ";//Add the name of the next employee to our list, separated by a comma
		}
		return out.substring(0,out.length()-2);//Chop off that last comma
	}

	/*Method to find the current top seller at the CarDealership
	Params: none
	Returns: A String, the name, or names of the top seller(s)*/
	public String getTopSeller(){
		SalesRep top = this.team.get(0);//Get the first team member. A good starting point.
		for (SalesRep s : this.team) {//Start looking through all of our reps
			if(s.getNumSold()>top.getNumSold()){//Compare our current rep to the next one
				top = s;//If the existing one has sold less, swap it out for the next one
			}
		}
		//Now we've found the SalesRep who sold the most. But what if some other reps have tied with our top seller?
		//Our car dealership is renown for its fair practices, and we want to keep our workers happy.
		String names = top.getName();//Start our output string with the name of the top seller.
		for (SalesRep s : this.team) {//Look through the team again
			if(s.getNumSold()==top.getNumSold()&&!(top.getName().equals(s.getName()))){//Check and see if anybody has tied with our top seller
				names += ", "+s.getName();//Add their name to the output string, they deserve equal recognition for their hard work
			}
		}
		return names+" has sold the most cars this year. ("+top.getNumSold()+")";//Return a string to state who sold the most
	}

	/*Method to find the current bottom seller at the CarDealership
	Params: none
	Returns: A SalsRep, whose fate now hangs in the balance*/
	public SalesRep getBottomSeller(){
		SalesRep bottom = this.team.get(0);//Get the first team member. A good starting point.
		for (SalesRep s : this.team) {//Start looking through all of our reps
			if(s.getNumSold()<bottom.getNumSold()){//Compare our current rep to the next one
				bottom = s;//If the existing one has sold more, swap it out for the next one
			}
		}
		return bottom;//Return the worst sales rep we currently employ. We won't be seeing them anymore.
	}

	/*Method to fire a SalesRep. Yes, I know this wasn't in the requirements.
	Params: A SalesRep, who soon won't be a SalesRep
	Returns: nothing*/
	public void fire(SalesRep rep){
		this.team.remove(rep);//Remove the rep from our team.
		System.out.println(rep.getName()+" has been fired.");//Print a message confirming their departure
		if (this.team.size()==0) {//If we've run out of employees, it's the end of this car dealership
			System.out.println("Looks like you've run out of employees.");
			System.out.println("You had to shut down your dealership, since you could not find anybody who wished to work for you.");
			System.out.println("Game over!");
			System.exit(0);//See ya!
		}
	}
}