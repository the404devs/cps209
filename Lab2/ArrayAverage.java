public class ArrayAverage
{
   public static void main(String[] args)
   {
      int[] data = {2, 34, 57, 31, 5, 79, 88, 62, 98, 53, 42};
      
      //-----------Start below here. To do: approximate lines of code = 4
      // 1. set total to zero ; Hint: use a double 
      
      double total = 0;
      //2. use a for loop to add up all the integers in data. Recall we know the length of an array .length
      for (int x=0; x<data.length; x++) {
        total+=data[x];
      }
      
      
      
      //3. computer the average
      double average = total/data.length;
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.printf("Average = %.2f\n", average) ;
  	  System.out.println("EXPECTED:") ;
  	  System.out.println("Average = 50.09") ;
   }
}
