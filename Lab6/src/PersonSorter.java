import java.util.Arrays;
import java.util.ArrayList;
/**
   Testing the Person class that implements Comparable<Person>
   to see that the sorting is from young to old.
 */
public class PersonSorter {

  public static void main(String[] args) {
    Person[] persons = new Person[4];
    persons[0] = new Person();
    persons[0].setFirstName("Elvis");
    persons[0].setLastName("Goodyear");
    persons[0].setAge(56);

    persons[1] = new Person();
    persons[1].setFirstName("Stanley");
    persons[1].setLastName("Clark");
    persons[1].setAge(8);

    persons[2] = new Person();
    persons[2].setFirstName("Jane");
    persons[2].setLastName("Graff");
    persons[2].setAge(16);

    persons[3] = new Person();
    persons[3].setFirstName("Nancy");
    persons[3].setLastName("Goodyear");
    persons[3].setAge(69);

    System.out.println("Initial Order:");

    for (int i=0; i<4; i++) {
      Person person = persons[i];
      String lastName = person.getLastName();
      String firstName = person.getFirstName();
      int age = person.getAge();
      System.out.println(lastName + ", " + firstName + ". Age:" + age);
    }

    Arrays.sort(persons);

    System.out.println();
    System.out.println("Sorted by age (young to old):");

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
       Sorting is from young age to older.
       @return 1 if this person is older than the other person, 
              -1 if this person is younger than the other person, and
	      0 if this person is the same age as the other person.
     */    
    //-----------Start below here. To do: approximate lines of code = 3
    //-----------Start below here. To do: approximate lines of code = 3
    // 1. write the compareTo method for the Comparable interface
    
    public int compareTo(Object x){
      Person c = (Person)x;
      if (this.getAge()>c.getAge()) {
        return 1;
      }
      else if (this.getAge()<c.getAge()) {
        return -1;
      }
      else{
        return 0;
      }

    }
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
