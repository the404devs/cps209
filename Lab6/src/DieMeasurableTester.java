import java.util.* ;
/**
   Program to test the Die class (a Die is a single Dice), where the Die class is
   the Die class but changed so that it is measurable.
   There are two "todo" regions in the Die class -- both are 
   necessary for making Die implement Measurable.  Fill them in.

   There is nothing to do in this tester class, so do not change it.
*/
public class DieMeasurableTester
{
    public static void main(String[] args)
    {
    	Random random = new Random(25) ;
    	Die die = new Die(500, random) ;
    	DataSet dataSet = new DataSet() ;
    	final int THROWS = 500 ;
    	//Throw the die many times and get the average
    	for (int i = 1 ; i <= THROWS ; i++) {
    	    die = new Die(500, random) ;
    	    die.cast() ;
    	    dataSet.add(die) ;
    	}
    	System.out.println("---------------------") ;
    	System.out.printf("The average value after %d throws is %.1f\n",
    			  THROWS, dataSet.getAverage()) ;
    	System.out.println("Expected:\nThe average value after 500 throws is 262.8") ;
    	System.out.println("---------------------") ;
    	Die maxDie = null ;
    	//-----------Start below here. To do: approximate lines of code = 1
    	//-----------Start below here. To do: approximate lines of code = 1
    	// 1. assign to maxDie the die with the largest value showing from DataSet
    	maxDie = (Die)dataSet.getMax();
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    	System.out.println("The die with the maximum showing is " + maxDie) ;
    	System.out.println("Expected:\nThe die with the maximum showing is Die[sideup = 500]") ;
    	System.out.println("---------------------") ;
    	die = new Die(500, random) ;
    	die.cast() ;
    	dataSet.add(die) ;
    	System.out.printf("The average value after %d throws is %.1f\n",
    			  THROWS + 1, dataSet.getAverage()) ;
    	System.out.println("Expected: not shown.") ;
    	System.out.println("---------------------") ;
    }
}
/**
   This class Die models a die that, when cast, lands on a random face.
   You might wonder how we manage to use a Random object without specifying
   the seed in this case, while still being able to predict the output.
   When you see what the test class does (takes the average of 10,000 throws),
   you will see why the seed doesn't matter.

   class Die is modified to implement Measurable.  
*/
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// Write the "class ... " part so that Measurable is implemented, but do not say public, since only one class can be public in a file
class Die implements Measurable
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
    private Random random ;
    private int sides ;
    private int sideUp ;

    /**
       initializes a die with a given number of sides and a given 
       pseudorandom number generator.
       @param sides the number of sides, e.g., 6 for normal die
       @param random the pseudorandom number generator
     */    
    public Die(int sides, Random random)
    {
    	this.sides = sides ;
    	this.random = random ;
    	sideUp = 0 ;
    }
    /**
       Initializes a die with a given number of sides
       @param sides the number of sides, e.g., 6 for normal die
     */    
    public Die(int sides)
    {
    	this.sides = sides ;
    	random = new Random() ;
    	sideUp = 0 ;
    }
    /**
       Simulates a throw of a die
       @return the face of the die
     */    
    public int cast() 
    {
    	sideUp = 1 + random.nextInt(sides) ;
    	return sideUp ;
    }
    /**
       Returns a string representation, like Die[sideUp = 3]
       @return a string representation, like Die[sideUp = 3]
     */    
    public String toString() 
    {
	     return getClass().getName() + "[sideup = " + sideUp + "]" ;
    }
    /**
       Gets the measure in the way required by the interface
       @return the face of the die when it is cast.
     */    
    //-----------Start below here. To do: approximate lines of code = 2
    //-----------Start below here. To do: approximate lines of code = 2
    // 1. public signature 
    public double getMeasure(){
      return this.sideUp;
    }
    
	//2. return the measure
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
/**
   DataSet example from Chap. 6 of Horstmann, Big Java
   modified in 9.1 to use Measurable interface
   @opensource yes
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
