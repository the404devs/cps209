/**
 *
 * Removes all 0 elements from an ArrayList
 */
import java.util.ArrayList;

public class RemoveZeroes 
{
    public static void main(String[] args)
	{
	   ArrayList<Integer> a = new ArrayList<Integer>();
	  

	   // Add some integers to the array list
	   a.add(14); a.add(0); a.add(19); a.add(3);
	   a.add(15); a.add(0); a.add(18); a.add(0);
	   a.add(44); a.add(0); a.add(51); a.add(78);
	   // You can also create an Integer wrapper explicitly and add to the array list
	   a.add(new Integer(83));
	   
	   // Print the array list - Not the use of the size() method and the get() method
	   for (int i = 0; i < a.size(); i++)
	   {
	      System.out.print(a.get(i) +  " ");
	   }
	   System.out.println();

	   // Remove the 0 elements
	   ArrayList<Integer> aNoZeros = removeZeros(a);

	   // Print ArrayList a again to see new elements.
	   for (int i = 0; i < aNoZeros.size(); i++)
	   {
	      System.out.print(aNoZeros.get(i) +  " ");
	   }
	   System.out.println();
	}
	
	
	public static ArrayList<Integer> removeZeros(ArrayList<Integer> p)
	{
	      // The easy way: Create a new array list and
	      // only copy the non-zero numbers into it. Use a for loop
		  //-----------Start below here. To do: approximate lines of code = 5
		  //
		  
		  ArrayList<Integer> out = new ArrayList<Integer>();
		  for (int x=0; x<p.size(); x++) {
		  	if (p.get(x)!=0)
		  		out.add(p.get(x));
		  }
		  return out;
		  
		  
		  
		  
		  
		  
		  
	      // Return the newly created array list
		  
		  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
