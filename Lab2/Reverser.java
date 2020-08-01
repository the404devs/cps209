/**
   This class has a method that returns the reverse of 
   an array of integers, 
   but it does NOT change the array called a in the main method.
 */
import java.util.* ;



public class Reverser
{
	   public static String toString(int[] array)
    {
		String result = "[" ;
		for (int i = 0 ; i < array.length - 1; i++) {
		    result += array[i] + ", " ;
		}
		result += array[array.length - 1] + "]" ;
		return result ;
    }
    public static void main(String[] args)
    {
	int[]a = new int[]{14, 2, 19, 3, 15, 22, 18, 7} ;

	int[] b = reverse(a) ;
	System.out.println("a = " + toString(a)) ;
	System.out.println("b = " + toString(b)) ;

	a = new int[]{14, 100, 33, 72, 2, 19, 3, 15, 22, 18, 7} ;
	b = reverse(a) ;
	System.out.println("a = " + toString(a)) ;
	System.out.println("b = " + toString(b)) ;
    }
    /**
       Makes a new array that has the elements of the given array 
       in reverse order.  No change to the parameter array.
       @param anArray the int array to reverse
       @return a new int array which is the reverse of the given array
     */
    public static int[] reverse(int[] anArray)
    {
	//-----------Start below here. To do: approximate lines of code = 4
	// Write the body of the reverse method here
	// Hints: 
	// Create a new empty array with the same length as the parameter array
	// Go through each integer element in the parameter array (use a for loop) 
	// set the last element of the new array to the first element of the parameter array, 
	// set the second last element to the second element etc
	// when finished, return the new array
	// don't forget you know the length of the array
	
	int[] out = new int[anArray.length];
	for(int x=0;x<anArray.length;x++){
		out[anArray.length-(x+1)]=anArray[x];
	}
	return out;
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
}
