/**
   Converts money using CurrencyConverter
 */
import java.util.* ;

public class CurrencyConverterTester
{
    public static void main(String[] args)
    {
	//Normally the scanner is based on System.in,
	//Scanner scanner = new Scanner(System.in) ;
	//but for predictability we set the input to a fixed sequence:
	Scanner scanner = new Scanner("0.79447 100 20 88.88 q") ;

	System.out.print("Conversion factor (euros per dollar): ") ;
	//We could use scanner.nextDouble() here, but this is an example
	//of using parseDouble, which you need in the next loop.
	String input = scanner.next() ;
	double rate = Double.parseDouble(input) ;
	System.out.println(rate) ;
	//-----------Start below here. To do: approximate lines of code = 1
	// 1. make the CurrencyConverter object based on the rate
	CurrencyConverter cc = new CurrencyConverter(rate);
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

	System.out.print("Dollar value (Q to quit): ") ;
	input = scanner.next() ;
	System.out.println(input) ; //echo the input
	//-----------Start below here. To do: approximate lines of code = 7
	// 1. write a while loop where the condition is that input is not "Q" or "q" ; 
	while(!input.toLowerCase().equals("q")){
	    //2. use parseDouble to get the dollars amount ; 
		double dollarAmount = Double.parseDouble(input);
	    //3.  use the converter object to convert the dollars to euros ; 
		double euros = cc.convert(dollarAmount);
	    //4.  print the dollars and euros in the style shown in the Expected region (Hint: use printf); 
		System.out.printf(dollarAmount + " dollars = "+euros+" euros.\n");
	    //5. prompt for the next input: Dollar value (Q to quit):   
		System.out.printf("Dollar value (Q to quit): ");
	    //6. read the next input ; 
		input = scanner.next() ;
	    //7. echo the input (i.e., print it out)
		System.out.println(input) ;
	}
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	System.out.println("Expected:") ;
	System.out.println(
			   "Conversion factor (euros per dollar): " +
			   "0.79447\n" +
			   "Dollar value (Q to quit): " +
			   "100\n" +
			   "100.00 dollars = 79.45 euros.\n" +
			   "Dollar value (Q to quit): " +
			   "20\n" +
			   "20.00 dollars = 15.89 euros.\n" +
			   "Dollar value (Q to quit): " +
			   "88.88\n" +
			   "88.88 dollars = 70.61 euros.\n" +
			   "Dollar value (Q to quit): " +
			   "q"
			   ) ;
    }
}
