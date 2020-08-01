import java.util.TreeSet;
import java.util.Set;

/**
   Illustrates basic operations of a set.
   Your job is to write the static method for difference of sets.
*/
public class SetTester3
{
    public static void main(String[] args) 
    {
	Set<String> set1 = new TreeSet<String>() ;
	set1.add("A") ;
	set1.add("B") ;
	set1.add("C") ;
	set1.add("D") ;
	set1.add("F") ;
	set1.add("G") ;
	System.out.println("set1, the tree set: " + set1) ;
	
	Set<String> set2 = new TreeSet<String>() ;
	set2.add("B") ;
	set2.add("D") ;
	set2.add("E") ;
	set2.add("F") ;
	set2.add("G") ;
	System.out.println("set2, the tree set: " + set2) ;
	
	System.out.println("C is in set1: " + set1.contains("C")) ;
	System.out.println("C is in set2: " + set2.contains("C")) ;
	System.out.println("Removing C from set1: " +set1.remove("C")) ;
	System.out.println("Removing C from set2: " +set2.remove("C")) ;
	Set set3 = difference(set1, set2) ;
	System.out.println("Difference: " + set1 + " - " + set2 
			   + " = " + set3) ;
    }
    /** 
	A method that returns the difference of two sets.
	@param x first set
	@param y second set
	@return the difference set, that is, x - y
     */
    public static Set<String> difference(Set<String> x, Set<String> y)
    {
	//-----------Start below here. To do: approximate lines of code = 5
	// 1. fill in the difference method
	Set<String> z = new TreeSet<String>();

	for (String a : x) {
		if (!y.contains(a)) {
			z.add(a);
		}
	}
	return z;
	
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
