import java.awt.Color ;
/**
   Car class.  So far it has a Color instance variable.  Your job is to add 
   an instance variable called kilometers that stores how many kilometers the car has driven (i.e. the odometer) 
   Adjust the constructor method to initialize kilometers
   Adjust the toString() method as inidicated.
 */
public class Car
{
    //instance variables
    private Color color ;
    //-----------Start below here. To do: approximate lines of code = 1
    // put here another instance variable, one for kilometers
    private double kilometers;
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    /**
       Constructor method: initialize instance variables
       @param color1 the given color
       @param odometer the given odometer reading
     */
    public Car(Color color1, double odometer)
    {
	     color = color1 ;
    	//-----------Start below here. To do: approximate lines of code = 1
    	// Complete this constructor method
    	kilometers = odometer;
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    /**
       Returns a string representation of the car.
       @return something like Car[color = ..., kilometers = ...]
     */
    public String toString()
    {
	//-----------Start below here. To do: approximate lines of code = 1
	// return "Car[color = " + color + "]"  ; but include kilometers
      return "Car[color = " + color +", kilometers = " + kilometers + "]";
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
