/**
   NoParking models a No Parking sign
 */
public class NoParking
{
    //-----------Start below here. To do: approximate lines of code = 15
    // 1. Write the class so that it works as expected with the unit tester.
    private String startTime;
    private String endTime;
    
    
    /**
       Constructs a NoParking object with a default time
     */
    public NoParking(){
      this.startTime = "0:00";
      this.endTime = "23:59";
    }
    
    
    
    
    /**
       Sets the start time
       @param the start time
     */
    public void setStartTime(String time){
      this.startTime = time;
    }
    
    
    
    /**
       Sets the end time
       @param the end time
     */
    
    public void setEndTime(String time){
      this.endTime = time;
    }
    
    
    /**
       Reverses the times
     */
    
    public void reverse(){
      String temp = startTime;
      startTime = endTime;
      endTime = temp;
    }
    
    
    
    
    /**
       Returns the string for no parking
       @return the string for no parking
     */
    public String toString(){
      return "No Parking between "+startTime+" and "+endTime;
    }
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
