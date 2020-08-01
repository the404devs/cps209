/**
  Append one array list onto the end of another 
*/

import java.util.ArrayList;

public class AppendArrayLists 
{
   public static void main(String[] args)
   {
      ArrayList<Integer> a = new ArrayList<Integer>();
      ArrayList<Integer> b = new ArrayList<Integer>();
      int i;

      for (i = 0; i < 5; i++)
      {
         /* Initialize array list a to some values */
         a.add(i + 3);
       
      }
      for (i = 0; i < a.size(); i++)
      {
         System.out.print(a.get(i) + " ");
      }
      System.out.println();
      
      for (i = 0; i < 3; i++)
      {
         /* Initialize array list b to some values */
         b.add(i + 2);
      }
      for (i = 0; i < b.size(); i++)
      {
         System.out.print(b.get(i) + " ");
      }
      System.out.println();
      // Append b to the end of a
      append(a, b);

      System.out.println("Result of append of a and b is ");

      for (i = 0; i < a.size(); i++)
      {
         System.out.print(a.get(i) + " ");
      }
      System.out.println();
   }

   /**
     Append the given ArrayList b to the end of the given ArrayList a 
     @param integer ArrayList a
	 @param integer ArrayList b
   */
   public static void append(ArrayList<Integer> a, ArrayList<Integer> b)
   {
      //-----------Start below here. To do: approximate lines of code = 3
      // append the integer elements in ArrayList b to the end of ArrayList0 a
      // Hint: use a for loop that goes through each element of ArrayList b, don't forget the class ArrayList has a size() method that
	  // Hint: google java ArrayList to see all the methods you can use. Use the add() method
      // the size() method tells you how many elements are stored in the array list			  
      for (int x=0; x<b.size(); x++) {
      	a.add(b.get(x));
      }
      
      
      
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }
}

