/**
 * 
 * Go through an ArrayList of integers and find the minimum element. Remove that element.
 * e.g. for the arraylist:   2,5,8,9,1,11,17  the result is 2,5,8,9,11,17
 */
import java.util.ArrayList;

public class RemoveMin
{
	
   public static void main(String[] args)
   {
	   ArrayList<Integer> a = new ArrayList<Integer>();
		  
	   // Add some integers to the array list
	   a.add(14); a.add(29); a.add(19); a.add(3);
	   a.add(15); a.add(62); a.add(18); a.add(97);
	   a.add(44); a.add(31); a.add(51); a.add(78);
	   	   
	   // Print the array list - Note the use of the size() method and the get() method
	   for (int i = 0; i < a.size(); i++)
	   {
	      System.out.print(a.get(i) +  " ");
	   }
	   System.out.println();
	   
	   //Remove the minimum element from ArrayList a
	   removeMin(a);
   
	   // Print the array list again 
	   for (int i = 0; i < a.size(); i++)
	   {
	      System.out.print(a.get(i) +  " ");
	   }
	   System.out.println();
	   
	   // Trick: You can also print the entire array by calling the toString() method
	   System.out.println(a.toString());
   }
   //-----------Start below here. To do: approximate lines of code = 8
   // Write the static method removeMin with the correct parameter and return type
   // See how removeMin is called above. HINT: google the ArrayList class and look at the
   // remove method. HINT: // Find the minimum value first then remove it from the arraylist
   
   private static ArrayList<Integer> removeMin(ArrayList<Integer> a){
   	int minPos=0;
   	int min=Integer.MAX_VALUE;
   	for (int x=0; x<a.size(); x++) {
   		if(a.get(x)<min){
   			min=a.get(x);
   			minPos=x;
   		}
   	}
   	ArrayList<Integer> b=a;
   	b.remove(minPos);
   	return b;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
