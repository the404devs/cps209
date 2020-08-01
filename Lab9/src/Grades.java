import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

/**
 * Grades - Write a program that uses a TreeMap to store a set of
 * names and their corresponding grades.  Based upon P16.7 in Big Java
 */
public class Grades 
{
    private Map <String, String> grades;
    
    //-----------Start below here. To do: approximate lines of code = 2
    // 1. Write a default constructor for the Grades class ; 
    public Grades(){
        this.grades = new TreeMap<String, String>()
    }
    
	//2. use a TreeMap for the grades map.
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    
    /**
     * Adds a name and its corresponding grade.
     * @param name the name, which will be the key
     * @param grade the grade, which will be the value
     */
    public void add(String name, String grade)
    {
	//-----------Start below here. To do: approximate lines of code = 1
	// put this key value pair into grades
	   this.grades.put(name,grade);
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
    /**
     * Returns the grade for a given name.
     * @param name the name.
     * @return the grade corresponding to the specified name.
     */
    public String getGrade(String name)
    {
	//-----------Start below here. To do: approximate lines of code = 1
	// use the map to fetch the value given the key
	   return this.grades.get(name);
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
    /**
     * Removes a name and it's corresponding grade.
     * @param name the name to remove.
     */
    public void remove(String name)
    {
	//-----------Start below here. To do: approximate lines of code = 1
	// use the map to remove the key name
	   this.grades.remove(name);
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
    /**
     * Returns a String containing all of the names and their
     * corresponding grades formatted as:
     * name1: grade
     * name2: grade 
     * @return all the names and their corresponding grades as a String 
     */
    public String toString()
    {
	//-----------Start below here. To do: approximate lines of code = 5
	// initialize the result string
	   String out = "";
	//let names be the set of keys
	
	//for each name
	for (String name : this.grades.keySet()) {
        out+=name+": "+this.grades.get(name)+"\n";
    }
	    //append the key: value pair followed by a newline
	
	//return the result string
	return out;
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
