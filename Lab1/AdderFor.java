/**
   Uses a for-loop to add the values from 1 to 1000
 */

public class AdderFor
{
    public static void main(String[] args)
    {
	//-----------Start below here. To do: approximate lines of code = 1
	// 1. Define a local integer constant called LIMIT equal to 1000
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	int sum = 0 ;

	//-----------Start below here. To do: approximate lines of code = 2
	// 1. write a for-loop with an index going from 1 to LIMIT; 2. add the index values as sum
	for (int i = 0; i<=1000; i++) {
		sum+=i;
	}
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	System.out.println("Sum = " + sum ) ;
	System.out.println("Expected: ") ;
	System.out.println("Sum = " + 500500) ;
    }
}
