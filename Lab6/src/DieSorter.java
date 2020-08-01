/**
   Sort Die objects using the interface Comparable<Die>
   and the classes ArrayList, Collections.
   The sorting is from small values to large (ascending).
   Todo:
   Make 120 Die objects, each with 100 sides.
   Throw each one
   Add the objects to the list.
   print the list
   Sort them using Collections.sort
   print the list
 */
import java.util.Collections ;
import java.util.ArrayList ;
import java.util.Random ;

public class DieSorter
{
    public static void main(String[] args)
    {
    	Random random = new Random(1) ;
    	ArrayList<Die> list = new ArrayList<Die>() ;
    	for (int i = 0 ; i < 120 ; i++) {
    	    Die die = new Die(100, random) ;
    	    die.cast() ;
    	    list.add(die) ;
    	}
    	System.out.println(list) ;
    	System.out.println("------------------------------------") ;
    	Collections.sort(list) ;
    	System.out.println(list) ;
    }
}
/**
   Die models a die that, when cast, lands on a random face
   Here the class is modified to implement Comparable<Die>.  
   The sorting of the Die objects is from small values to large.

   Notice there is a new constructor that takes the number of sides
   and a random number generator as parameters -- you need that constructor
   for this problem.
*/
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// Write the "class Die ... " part so that Comparable is implemented, but leave out the public specifier since only one class in the file can be public.
class Die implements Comparable
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
    private Random random ;
    private int sides ;
    private int sideUp ;

    /**
       Initializes sides with a given number of sides
       @param sides the number of sides, e.g., 6 for normal die
     */    
    public Die(int sides)
    {
    	this.sides = sides ;
    	random = new Random() ;
    	sideUp = 0 ;
    }
    /**
       Initializes sides and the random instance variable with the given parameters
       @param sides the number of sides, e.g., 6 for normal die
       @param random the random number generator
     */    
    public Die(int sides, Random random)
    {
    	this.sides = sides ;
    	this.random = random ;
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
       Gives a String representation of the Die
       @return the sideUp as a string
     */    
    public String toString()
    {
	     return "" + sideUp ;
    }
    /**
       Compares this die with another in form of Comparable interface.
       The sorting is from small values to larger values.
       @return 1 if this one has a bigger value, -1 if smaller, 0 if same
     */    
    //-----------Start below here. To do: approximate lines of code = 4
    //-----------Start below here. To do: approximate lines of code = 4
    // 1. public signature ; 
    
    public int compareTo(Object x){
      Die c = (Die)x;
      if (this.sideUp>c.sideUp) {
        return 1;
      }
      else if (this.sideUp<c.sideUp) {
        return -1;
      }
      else{
        return 0;
      }

    }
	//2. code for the -1 case ; 
    
	//3. code for the 1 case ; 
    
	//4. code for the 0 case. 
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
