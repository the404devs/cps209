/**
   Example from R15.1.
   Explain what the following code prints.  Draw pictures of the linked
   list after each step.  Just draw the forward links, as in Figure 1.
   
   Add a static method that returns a string representation of the list 
   in the form:
   list         string version
   []           /
   [A]          A -> /
   [A,B]        A -> B -> /
   etc.

   The expected output is:

A -> /
B -> A -> /
C -> B -> A -> /
C
B -> A -> /
B
A -> /
A
/

 */
import java.util.LinkedList ;
import java.util.Scanner ;

public class LinkedListTester1
{
    public static void main(String[] args)
    {
    	LinkedList<String> list = new LinkedList<String>() ;
    	list.addFirst("A") ;
    	System.out.println(toString(list)) ;
    	list.addFirst("B") ;
    	System.out.println(toString(list)) ;
    	list.addFirst("C") ;
    	System.out.println(toString(list)) ;
    	System.out.println(list.removeFirst()) ;
    	System.out.println(toString(list)) ;
    	System.out.println(list.removeFirst()) ;
    	System.out.println(toString(list)) ;
    	System.out.println(list.removeFirst()) ;
    	System.out.println(toString(list)) ;
    }
    /**
       A static method that gives a string representation of a linked
       list in the form:
       list         string version
       []           /
       [A]          A -> /
       [A,B]        A -> B -> /
       etc.
       @param list the linked list of type LinkedList<String>
       @return a string representation like A -> B -> /
     */
    //-----------Start below here. To do: approximate lines of code = 6
    // 0. the signature of the method 
    public static String toString(LinkedList<String> list){
      String out = "";
      for (String x : list) {
        out+=x+" -> ";
      }
      out+="/";
      return out;
    }
    
	//initialize result
    
	//for each element in the list
    
	    //append the element and arrow
    
    
	//append the /
    
	//return the result
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
