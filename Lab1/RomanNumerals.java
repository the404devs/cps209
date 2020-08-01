/**
   Converts Roman numerals to decimal value
   
*/
import java.util.Scanner;

public class RomanNumerals
{
	public static void main(String[] args)
	{
	   Scanner in = new Scanner("I C X D M L");

	   char romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 100") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 10") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 500") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1000") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 50") ;
	}
	
   /**
      Gives the value of the Roman numerals I X L C D M
      @param numeral a single Roman numeral
      @return the integer value of numeral
   */
   //-----------Start below here. To do: approximate lines of code = 14
   // write a static method valueOf with the appropriate parameters and return type. 	
   
   
   	private static int valueOf(char numeral){
   		if (numeral=='I') {
   			return 1;
   		}
   		else if (numeral=='C') {
   			return 100;
   		}
   		else if (numeral=='X') {
   			return 10;
   		}
   		else if (numeral=='D') {
   			return 500;
   		}
   		else if (numeral=='M') {
   			return 1000;
   		}
   		else if (numeral=='L') {
   			return 50;
   		}
   		else{
   			return 0;
   		}
   	}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
      // must be an M
   
   
   //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
