/**
   Uses a while loop to add the values from 1 to 1000
 */

public class AdderWhile
{
    public static void main(String[] args)
    {
	//-----------Start below here. To do: approximate lines of code = 1
	// 1. define a local integer constant called LIMIT equal to 1000
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	int sum = 0 ;

	//-----------Start below here. To do: approximate lines of code = 4
	// 1. define an index starting at 1 ; 2. while the index is less than or equal to LIMIT ; 3. add the index to sum ; 4. increment index
	
	int i = 1;
	while (i<=1000) {
		sum+=i;
		i++;
	}
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	System.out.println("Sum = " + sum ) ;
	System.out.println("Expected: ") ;
	System.out.println("Sum = " + 500500) ;
    }
}
