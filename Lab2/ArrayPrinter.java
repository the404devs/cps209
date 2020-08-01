/**
   This class has a main method that prints out an integer array in various ways
 */

public class ArrayPrinter
{
   public static void main(String[] args)
   {
      int[] data = {2, 34, 57, 31, 5, 79, 88, 62, 98, 53, 42};
      

      //-----------Start below here. To do: approximate lines of code = 2
      // Write a loop to print out even indices (NOTE: not the elements) of array data
	  // use System.out.print, not System.out.println so the numbers are printed on one line
      for (int x=0; x<data.length; x+=2) {
         System.out.print(x+" ");
      }
      
      
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println();
      System.out.println("EXPECTED:") ;
      System.out.println("0 2 4 6 8 10");
      

      //-----------Start below here. To do: approximate lines of code = 3
      // Write a loop to print out even integer elements stored in array data
	  // Hint: use the modulus operator % to determine if the integer is even
      
      for (int x=0; x<data.length; x++) {
         if(data[x]%2==0)
            System.out.print(data[x]+" ");
      }
      
      
      
      
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println();
      System.out.println("EXPECTED:") ;
      System.out.println("2 34 88 62 98 42");
      
      //-----------Start below here. To do: approximate lines of code = 2
      // Print out the elements in reverse order
	  //Hint: use a for loop but start at the end of the array and count down
      
      for (int x=data.length-1; x>=0; x--) {
         System.out.print(data[x]+" ");
      }
      
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println();
      System.out.println("EXPECTED:") ;
      System.out.println("42 53 98 62 88 79 5 31 57 34 2");

      //-----------Start below here. To do: approximate lines of code = 1
      // Print out only the first and last element
      System.out.println(data[0]+" "+data[data.length-1]);
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println("EXPECTED:") ;
      System.out.println("2 42");
   }
}
