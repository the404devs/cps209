import java.util.Arrays;
import java.util.ArrayList;
/**
   Testing the Person class that implements Comparable<Person>
   to see that the sorting is from young to old.
*/
public class PersonSorterByName
{
    public static void main(String[] args) 
    {
	Person[] persons = {
	    new Person("Elvis", "Goodyear", 56),
	    new Person("Stanley", "Clark", 8),
	    new Person("Jane", "Graff", 16),
	    new Person("Nancy", "Goodyear", 69),
	    new Person("Alice", "Goodyear", 100)
	} ;
	System.out.println("Initial Order:");

	for (int i = 0 ; i < 5; i ++) {
	    Person person = persons[i];
	    String lastName = person.getLastName();
	    String firstName = person.getFirstName();
	    int age = person.getAge();
	    System.out.println(lastName + ", " + firstName + ". Age:" + age);
	}

	Arrays.sort(persons);

	System.out.println();
	System.out.println("Sorted by name (alphabetically):");

	for (int i=0; i<4; i++) {
	    Person person = persons[i];
	    String lastName = person.getLastName();
	    String firstName = person.getFirstName();
	    int age = person.getAge();
	    System.out.println(lastName + ", " + firstName + ". Age:" + age);
	}
    }
}
/**
   This class Person models a person object that has a name and age.
   Notice there is no constructor other than the default one.
   You are setting up the Comparable<Person> interface so that the 
   sorting will be from young to old (ascending).
*/
//-----------Start below here. To do: approximate lines of code = 1
//-----------Start below here. To do: approximate lines of code = 1
// Write the "class Person ... " part so that Comparable is implemented, but leave off the public specifier since only one class in a file can be public
class Person implements Comparable
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
    private String firstName;
    private String lastName;
    private int age;
    /**
       Initializes firstName, lastName and age
       @param first the first name
       @param last the last name
       @param years the age in years
    */
    public Person(String first, String last, int years)
    {
	firstName = first ; lastName = last ; age = years ;
    }
    /**
       Accesses the first name
       @return firstName
    */    
    public String getFirstName() {
	return firstName;
    }
    /**
       Sets the first name
       @param firstName the new first name
    */    
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }
    /**
       Accesses the last name
       @return lastName
    */    
    public String getLastName() {
	return lastName;
    }
    /**
       Sets the last name
       @param lastName the new value.
    */    
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }
    /**
       Accesses the first age
       @return age
    */    
    public int getAge() {
	return age;
    }
    /**
       Sets the age
       @param age the new age
    */    
    public void setAge(int age) {
	this.age = age;
    }
    /**
       Compares this person with another in the form of Comparable interface.
       Sorting is alphabetical by last name
       but if the last name is the same, go by the first name
       @return -1 if this person's name comes before the other's name
       +1 if this person's name comes after the other's name
       0 if the names are the same
    */    
    //-----------Start below here. To do: approximate lines of code = 5
    //-----------Start below here. To do: approximate lines of code = 5
    // 1. write the compareTo method for the Comparable interface
    
    
    public int compareTo(Object i){
      Person c = (Person)i;
      int length = Math.min(c.getLastName().length(), this.getLastName().length());
      for (int x = 0; x<length; x++) {
        if ((int)this.getLastName().charAt(x)>(int)c.getLastName().charAt(x)) {
          return 1;
        }
        else if ((int)this.getLastName().charAt(x)<(int)c.getLastName().charAt(x)) {
          return -1;
        }
      }
      length = Math.min(c.getFirstName().length(), this.getFirstName().length());
      for (int x = 0; x<length; x++) {
        if ((int)this.getFirstName().charAt(x)>(int)c.getFirstName().charAt(x)) {
          return 1;
        }
        else if ((int)this.getFirstName().charAt(x)<(int)c.getFirstName().charAt(x)) {
          return -1;
        }
      }
      return 0;
    }
    
    
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
