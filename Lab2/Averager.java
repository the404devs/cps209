/**
   Finding the average of all elements in a 2D array.
 */
import java.util.* ;

public class Averager
{
    public static void main(String[] args)
    {
	//a two dimensional array
	int[][] a = {{5, 9, 3, 2, 14}, {77, 44, 22, 15, 99},
		         {14, 2, 3, 9, 5}, {88, 15, 17, 121, 33}} ;
	System.out.printf("Average = %.2f\n", average(a)) ;
	System.out.println("EXPECTED:") ;
	System.out.println("Average = 29.85") ;
	System.out.printf("Average of evens = %.2f\n", averageEvens(a)) ;
	System.out.println("EXPECTED:") ;
	System.out.println("Average of evens = 26.57") ;
	Random random = new Random(1) ;
	a = new int[100][1] ;
	for (int i = 0 ; i < 100 ; i++)
	    a[i][0] = random.nextInt(1000) ;
	System.out.println("For an array of random values in range 0 to 999:") ;
	System.out.printf("Average = %.2f\n", average(a)) ;
	System.out.printf("Average of evens = %.2f\n", averageEvens(a)) ;
    }
    /**
       Find the average of all elements of a two-dimensional array
       @param aa the two dimensional array
       @return the average as a double
     */
    public static double average(int[][] aa)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        // 1. set total to zero ; Hint: use a double 
        double total = 0;
        
	    //2. make a nested loop to visit each element ; 
        for (int x = 0; x<aa.length; x++) {
          for (int y = 0; y<aa[0].length; y++) {
            total += aa[x][y];
          }
        }
        return total/(aa.length*aa[0].length);
        
		//3. increase total with each element ; 
        
        
        
	   //4. return the average
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    /**
       Find the average of the even elements of a two-dimensional array
       @param aa the two dimensional array
       @return the average as a double
     */
    public static double averageEvens(int[][] aa)
    {
        //-----------Start below here. To do: approximate lines of code = 8
        // fill in the method
        double total = 0;
        int n = 0;
        for (int x = 0; x<aa.length; x++) {
          for (int y = 0; y<aa[0].length; y++) {
            if (aa[x][y]%2==0){
              total += aa[x][y];
              n++;
            }
          }
        }
        return total/(n);
        
        
        
        
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
