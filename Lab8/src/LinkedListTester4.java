/**
   This question practices the use of a list iterator.  You have to write
   a static toString(list, index) method that makes a string representation
   of a list and its iterator, where you are given the index of the next
   element that the iterator would return on a call to next().  

   The expected output is 

|
A|
AB|
ABC|
|ABC
|BC
B
C
BC|

 */
import java.util.LinkedList ;
import java.util.ListIterator ;
import java.util.Scanner ;

public class LinkedListTester4
{
    public static void main(String[] args)
    {
		LinkedList<String> list = new LinkedList<String>() ;
		ListIterator<String> iterator = list.listIterator() ;
		System.out.println(toString(list, iterator.nextIndex()));
		iterator.add("A") ;
		System.out.println(toString(list, iterator.nextIndex())) ;
		iterator.add("B") ;
		System.out.println(toString(list, iterator.nextIndex())) ;
		iterator.add("C") ;
		System.out.println(toString(list, iterator.nextIndex())) ;
		iterator = list.listIterator() ;
		System.out.println(toString(list, iterator.nextIndex())) ;
		if (iterator.next().equals("A")) 
		    iterator.remove() ;
		System.out.println(toString(list, iterator.nextIndex())) ;
		while (iterator.hasNext()){
        System.out.println("*");
		    System.out.println(iterator.next()) ;}
		System.out.println(toString(list, iterator.nextIndex())) ;
    }
    /**
       A static method to return a string representation of the
       list and the iterator.  Note that the listIterator method 
       nextIndex gives the index of the next element that would be 
       returned by a call to next, or list size if the list iterator
       is at the end of the list. The four possible pictures for a 
       list [A,B,C] are:
       |ABC             here index would be 0
       A|BC             here index would be 1
       AB|C             here index would be 2
       ABC|             here index would be 3 (i.e., the size of the list)
       
       @param list the linked list of type LinkedList<String>
       @param index of next element that the iterator would return by next
       @return a string representation like A|BC
     */
    //-----------Start below here. To do: approximate lines of code = 11
    // 1. signature of method ; 
    public static String toString(LinkedList<String> list, int i){
    	String out = "";
    	int c = 0;
    	if (i==c) {
    		out+="|";
    	}
    	for (String x : list) {
    		out+=x;
    		c++;//this hurt to type
    		if (i==c) {
    			out+="|";
    		}
    	}
    	return out;
    }
    
	//2. initialize result to empty string ; 
    
	//3. if index is 0 ; 
    
	    //then put "|" on result ; 
    
	//4. initialize count ; 
    
	//5. for each element in the list ; 
    
	    //6. append element to result ; 
    
	    //7. increment count ; 
    
	    //8. if count is index ; 
    
		//then append "|" ; 
    
    
	//9. return result.
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
