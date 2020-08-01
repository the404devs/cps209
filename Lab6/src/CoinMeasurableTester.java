import java.util.* ;
/**
   Program to test the Coin class, where the Coin class is
   the usual Coin class but changed so that it is Measurable.
   There are two "todo" regions in the Coin class -- both are 
   necessary for making Coin implement Measurable.  Fill them in.

   Add two lines to this class to assign the biggest coin to a variable
   of type Coin and then to print it.
   @opensource always
*/
public class CoinMeasurableTester
{
    public static void main(String[] args)
    {
    	DataSet dataSet = new DataSet() ;
    	dataSet.add(new Coin(1000, "1000coin")) ;
    	dataSet.add(new Coin(3000, "3000coin")) ;
    	dataSet.add(new Coin(1000, "1000coin")) ;
    	dataSet.add(new Coin(7000, "7000coin")) ;
    	dataSet.add(new Coin(1000, "1000coin")) ;
    	dataSet.add(new Coin(5000, "5000coin")) ;
    	System.out.println("---------------------") ;
    	System.out.printf("The average coin value is %.1f\n",
    			  dataSet.getAverage()) ;
    	System.out.println("Expected:\nThe average coin value is 3000.0") ;
    	System.out.println("---------------------") ;
    	Coin maxCoin = null ;
    	//-----------Start below here. To do: approximate lines of code = 1
    	//-----------Start below here. To do: approximate lines of code = 1
    	// assign the maximum coin to a maxCoin 
    	maxCoin = (Coin)dataSet.getMax();
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    	System.out.println("The maximum coin is: " + maxCoin) ;
    	System.out.println("Expected:\nThe maximum coin is: Coin[7000coin, 7000.0]") ;
    	System.out.println("---------------------") ;
    	//An output without giving the "Expected"
    	dataSet.add(new Coin(20000, "20000coin")) ;
    	System.out.printf("The average coin value is %.1f\n", dataSet.getAverage()) ;
    	System.out.println("Expected not shown.") ;
    	System.out.println("---------------------") ;
    }
}
/**
   A coin with a monetary value.
   This version appears in Chapter 9 of Big Java, showing the 
   implementation of the Measurable interface
*/
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// fill in the public class ... part so that Measurable is implemented, but skip the "public" specifier since only one class can be declared public in a file.
class Coin implements Measurable
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
    private double value;
    private String name;
    
    /**
       Initializes value and name
       @param aValue the monetary value of the coin.
       @param aName the name of the coin
    */
    public Coin(double aValue, String aName) 
    { 
    	value = aValue; 
    	name = aName;
    }
    /**
       Gets the coin value.
       @return the value
    */
    public double getValue() 
    {
	   return value;
    }
    /**
       Gets the coin name.
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
	   return "Coin[" + name + ", " + value + "]" ;
    }
    /**
       Gets the coin value
       @return the value of the coin
    */
    //-----------Start below here. To do: approximate lines of code = 2
    //-----------Start below here. To do: approximate lines of code = 2
    // 1. public signature 
    public double getMeasure(){
      return value;
    }
    
	//2. return the measure
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
/**
   DataSet example from Chap. 6 of Horstmann, Big Java
   modified in 9.1 to use Measurable interface
 */
class DataSet
{
    private double sum ;
    private int count ;
    private Measurable max ;
    /**
       Constructs DataSet object empty.
     */
    public DataSet()
    {
    	sum = 0 ;
    	count = 0 ;
    	max = null ;
    }
    /**
       Adds an element to the dataset
       @param x the thing to add
     */
    public void add(Measurable x)
    {
    	sum += x.getMeasure() ;
    	if (count == 0 || max.getMeasure() < x.getMeasure())
    	    max = x ;
    	count ++ ;
    }
    /**
       Returns the maximum or null if none
       @return the max
     */
    public Measurable getMax()
    {
	     return max ;
    }
    /**
       Returns the average
       @return the average or zero if none
     */
    public double getAverage()
    {
    	if (count == 0)
    	    return 0 ;
    	else
    	    return sum / count ;
    }
}
/**
   An interface used as an example in Big Java.
   A class that implements this interface has a way to measure it,
   namely the getMeasure method.
 */
interface Measurable
{
    double getMeasure() ;
}
