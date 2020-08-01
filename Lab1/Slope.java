import java.util.Scanner;
/**
   Add code below so that when the line is vertical, that is, the denominator
   of the slope calculation is zero, then nothing is done. That is, no  
   slope calculation and no slope printing.
   Ignore for now the for-loop, which is just there to test three sets of
   inputs.  Also ignore that the Scanner reads from a string rather than from
   the keyboard. That is just so that we know what the inputs will be.
*/
public class Slope 
{
    public static void main(String[] args)
    {
	String input = "0 0 5 5 9 15 10 10 10 15 10 30" ;
	Scanner in = new Scanner(input) ;
	for (int i = 0 ; i < 3 ; i++) {
	    //System.out.print("Input x coordinate of the first point: ");
	    double xcoord1 = in.nextDouble();

	    //System.out.print("Input y coordinate of the first point: ");
	    double ycoord1 = in.nextDouble();

	    //System.out.print("Input x coordinate of the second point: ");
	    double xcoord2 = in.nextDouble();

	    //System.out.print("Input y coordinate of the second point: ");
	    double ycoord2 = in.nextDouble();

	    double denominator = xcoord2 - xcoord1 ;
	    //-----------Start below here. To do: approximate lines of code = 1
	    // put a condition here to avoid the calculation 
	    //of slope and the printing when the denominator is 0.
	    if (denominator==0) {
	    	break;
	    }
	    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		double slope = (ycoord2 - ycoord1) / denominator ;
		System.out.println("The slope of the line is " + slope);
	    }
	} 
}
