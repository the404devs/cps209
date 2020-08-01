/**
   Sort Coin objects using the interface Comparable and the 
   classes ArrayList and Collections.
   Todo:
   In this class you add the Coin objects to the list.
   In the Coin class you make Coin implement Comparable.
 */
import javax.swing.* ;
import java.util.* ;

public class CoinSorter
{
    public static void main(String[] args)
    {
    	ArrayList<Coin> list = new ArrayList<Coin>() ;
    	//-----------Start below here. To do: approximate lines of code = 1
    	//-----------Start below here. To do: approximate lines of code = 1
    	// add to the list Coin objects in this order: quarter, dime, nickel, dime, nickel
    	list.add(new Coin(.25, "quarter")) ;
      list.add(new Coin(.10, "dime")) ;
      list.add(new Coin(.05, "nickel")) ;
      list.add(new Coin(.10, "Dime")) ;

      list.add(new Coin(.05, "Nickel")) ;
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    	System.out.println("-------------------------unsorted") ;
    	System.out.println(list) ;
    	System.out.println("Expected: ") ;
    	System.out.println("[quarter(0.25), dime(0.1), nickel(0.05), Dime(0.1), Nickel(0.05)]");
    	Collections.sort(list) ;
    	System.out.println("-------------------------sorted") ;
    	System.out.println(list) ;
    	System.out.println("Expected: ") ;
    	System.out.println("[nickel(0.05), Nickel(0.05), dime(0.1), Dime(0.1), quarter(0.25)]") ;
    }
}
/**
   Coin represents a coin with a monetary value.
   Here we implement the Comparable interface so that when sorting
   Coin, the smaller coin values come first.
*/
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// Write the "class Coin ... " part so that Comparable is implemented, but leave out the public specifier since only one class can be public in a file.
class Coin implements Comparable
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
    private double value;
    private String name;
    /**
       Constructor method to initialize value and name
       @param aValue the monetary value of the Coin object.
       @param aName the name of the Coin object
    */
    public Coin(double aValue, String aName) 
    { 
    	value = aValue; 
    	name = aName;
    }
    /**
       Gets the Coin object value.
       @return the value
    */
    public double getValue() 
    {
	     return value;
    }
    /**
       Gets the Coin object name.
       @return the name
    */
    public String getName() 
    {
	   return name;
    }
    /**
       Gets the string rep. 
       @return the representation
    */
    public String toString()
    {
	   return name + "(" + value + ")" ;
    }
    /**
       The method required by the Comparable interface for comparing objects.
       Make it so that the smaller coin value comes first.
       @return -1 if this comes first, 1 if this comes second, 0 if same
    */
    //-----------Start below here. To do: approximate lines of code = 4
    //-----------Start below here. To do: approximate lines of code = 4
    // 1. public signature ; 
    public int compareTo(Object x){
      Coin c = (Coin) x;
      if(this.getValue()>c.getValue())
          return 1;
      else if (c.getValue()>this.getValue())
        return -1;
      else 
        return 0;
    }
    
	//2. code for the -1 case ; 
    
	//3. code for the 1 case ; 
    
	//4. code for the 0 case.
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
