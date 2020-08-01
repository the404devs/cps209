import java.util.Collections ;
import java.util.ArrayList ;
import java.util.Arrays ;
/**
   Sorting a list of strings alphabetically, using the Collections sort method.

   The Comparable interface is a commonly used interface in Java. Look
   up the Comparable interface in the API documentation.  It requires 
   a compareTo method, such that

   a.compareTo(b)

   returns

   1 if a is larger than b
   -1 if a is smaller than b
   0 if a and b are the same 

   Since compareTo determines which of two objects is larger, this
   interface is used to decouple sorting methods from the classes that
   are sorted.  The String class implements Comparable<String>, so we
   can sort strings alphabetically using a sort method that sorts 
   Comparable objects.
   The Collections.sort method is one such method.

   Here we make a list of strings and print the list and then print it
   after sorting.

   All you have to do here is add three more String objects to the list:
   purple, mauve, and brown, and then print the list, sort it, and print
   it again.
 */
public class StringSorter
{
    public static void main(String[] args)
    {
		String[] array = {"blue", "red", "yellow",  "cyan",  "orange",  
				  "purple",  "mauve",  "brown"} ;
		ArrayList<String> list = new ArrayList<String>() ;
		//-----------Start below here. To do: approximate lines of code = 1
		//-----------Start below here. To do: approximate lines of code = 2
		// 1. write a for loop to copy the elements of the array to the ArrayList list
		for (String x : array) {
			list.add(x);
		}
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		System.out.println("--------------original list:") ; 
		System.out.println(list) ; 
		Collections.sort(list) ;
		System.out.println("--------------sorted list:") ; 
		System.out.println(list) ;
		System.out.println("--------------original array:") ; 
		System.out.println(Arrays.toString(array)) ; 
		//-----------Start below here. To do: approximate lines of code = 2
		//-----------Start below here. To do: approximate lines of code = 2
		// 2. sort the array using Arrays.sort
		Arrays.sort(array);
		System.out.println("--------------sorted  array:") ; //
		//3. print the sorted array
		System.out.println(Arrays.toString(array));
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		String x = "No changes outside todo regions";
    }
}
