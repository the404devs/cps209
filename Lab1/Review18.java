/**
  R4.18 Printing some expressions.
 */
import javax.swing.* ;
import java.util.* ;

public class Review18
{
    public static void main(String[] args)
    {
	int n = 4 ;
	String s = "Hello" ;
	String t = "World" ;
	//-----------Start below here. To do: approximate lines of code = 5
	// 1. print s + t ; 
	System.out.println(s+t);
	//2. print s + n ; 
	System.out.println(s+n);
	//3. print n + t ; 
	System.out.println(n+t);
	//4. print s.substring(1, n) ; 
	System.out.println(s.substring(1,n));
	//5. print s.length() + t.length() 
	System.out.println(s.length()+t.length());
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	System.out.println("Expected:") ;
	System.out.println("HelloWorld") ;
	System.out.println("Hello4") ;
	System.out.println("4World") ;
	System.out.println("ell") ;
	System.out.println("10") ;
    }
}
