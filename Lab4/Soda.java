public class Soda
{
    //-----------Start below here. To do: approximate lines of code = 9
    //
   /**
    * Create 3 instance variables. One is of type String and holds
    * the name of the Soda, one is of type int and stores the amount
    * of sugar and one is also of type int and stores the volume of the
    * soda can 
    */
    String name;
    int sugar;
    int volume;
    
    
    
   /**
      Create a constructor method with 3 parameters to initialize 
      the 3 instance variables
   */
    
    Soda(String name, int sugar, int volume){
      this.name = name;
      this.sugar = sugar;
      this.volume = volume;

    }
    
    
    
    
    
   /**
      Create a public method getSweetness() that returns the amount of sugar
   */
    public int getSweetness(){
      return sugar;
    }
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   /**
    * Create a method: public String compareSweetness(Soda other)
    * 
    * This method compares the amount of sugar in the this Soda object
    * (e.g. this.sugar) with the amount of sugar in the other Soda object
    * (e.g. other.getSweetness() or other.sugar)
    * 
    * If amount of sugar in the this object is greater than the amount in other
    * return the String containing:
    * name of this soda followed by " is sweeter than " followed by the name
    * of the other soda
    * 
    * If amount of sugar in the other Soda object is greater than the amount in
    * the this object, return the String containing:
    * name of other soda followed by " is sweeter than " followed by the name
    * of the this soda 
    * 
    * If amount of sugar in the this Soda object is the same as the amount in
    * the other object, return the String containing:
    * name of this soda followed by " has the same sweetness as " followed by the name
    * of the other soda 
    * 
    */
   public String compareSweetness(Soda other)
   {
     //-----------Start below here. To do: approximate lines of code = 6
     //
    if (this.getSweetness()>other.getSweetness())
      return this.name +" is sweeter than "+ other.name;
    else if (this.getSweetness()==other.getSweetness())
      return this.name +" has the same sweetness as "+ other.name;
    else
      return other.name +" is sweeter than "+ this.name;
     
     
     
     
     
     
     //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }
}
