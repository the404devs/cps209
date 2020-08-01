/**
   A simple currency converter.
   It multiplies a given rate by a given amount to get a converted amount.
*/
public class CurrencyConverter
{  
    //instance variables
    private double rate ; //conversion rate

    /**
       Constructor method: initialize rate with a given rate (aRate)
       @param rate the conversion rate
    */
    public CurrencyConverter(double aRate)
    {   
    	//-----------Start below here. To do: approximate lines of code = 1
    	// 1. fill in this constructor to set the instance variable
    	rate=aRate;
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    
    /**
       Converts given amount according to rate.
       @param amount the amount to convert
       @return the product of rate and amount
    */
    public double convert(double amount)
    {  
    	//-----------Start below here. To do: approximate lines of code = 1
    	// 1. fill in this method to return product of rate and amount
    	return Math.round((amount*rate)*100.0)/100.0;//sneaky rounding
    	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}



