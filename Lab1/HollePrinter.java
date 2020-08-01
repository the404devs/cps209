/**
   P2.13.  Write a program HollePrinter that switches the letters "e"
   and "o" in a string. Use the replace method repeatedly. Demonstrate
   that the string "Hello, World!" turns into "Holle, Werld!"
 */

public class HollePrinter
{
    public static void main(String[] args)
    {
      String greeting = "Hello, World!" ;
      String encoding ;
    	//Write three lines using the replace method.
    	//-----------Start below here. To do: approximate lines of code = 3
    	// 1. replace e with @ ; 
    	encoding = greeting.replace("e","http://the404.ml/");
    	//2. replace o with e ; 
    	encoding = encoding.replace("o","e");
    	//3. replace @ with o
    	encoding = encoding.replace("http://the404.ml/","o");
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println("Encoding: " + encoding) ;
      System.out.println("Expect: Holle, Werld!") ;
    }
}
